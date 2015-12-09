package problems._4;

import java.io.IOException;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long palindrome = 	getLargest3X3PalindromeLessThan(testCase.longValue());
			System.out.println(palindrome);
		}
	}

	private static long getLargest3X3PalindromeLessThan(long N) {
		long largestPalindrome = 0;
		int secondNumberLimit = 99;
		for(int i = 999; i>99; i--){
			for(int j=i; j>secondNumberLimit;j-- ){
				int currentNumber = i*j;
				if(currentNumber>N){
					continue;
				}
				if(currentNumber < largestPalindrome){
					secondNumberLimit = j;
					break;
				}
				if(isPalindrome(currentNumber)){
					
					largestPalindrome = currentNumber;
					secondNumberLimit = j;
					break;
				}
			}		
		}
		return largestPalindrome;
	}

	private static boolean isPalindrome(int number) {
		int reverseNumber = 0;
		int copyNumber = number;
		while(copyNumber!=0){
			int reminder = copyNumber%10;
			copyNumber = copyNumber/10;
			reverseNumber = (reverseNumber*10)+reminder;
		}
		return (number == reverseNumber);
	}
}
