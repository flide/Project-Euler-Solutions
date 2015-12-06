package problems._3;

import java.io.IOException;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long largestPrimeFactor = getLargestPrimeFactor(testCase.longValue());
			System.out.println(largestPrimeFactor);
		}
	}

	private static long getLargestPrimeFactor(long inputValue) {
		long dividend = inputValue;
		long divisor = 2;
		
		while(dividend%divisor == 0){
			dividend = dividend/divisor;
		}
		divisor++;
		long maxPrimeLimit = (long) Math.sqrt(dividend);
		while(dividend !=1){
			if(dividend%divisor == 0){
				if(divisor > maxPrimeLimit){
					break;
				}
				dividend = dividend/divisor;
				maxPrimeLimit = (long) Math.sqrt(dividend);
			} else {
				divisor+=2;
				if(divisor > maxPrimeLimit){
					divisor = dividend;
				}
				
			}
		}
		
		return divisor;
	}
}
