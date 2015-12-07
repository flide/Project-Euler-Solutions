package problems._7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long n_th_prime = getNthPrime(testCase.longValue());
			System.out.println(n_th_prime);
		}
	}

	private static List<Integer> primeNumbers = new ArrayList<>();
	static {
		primeNumbers.add(2);
	}
	private static int currentNumber = 3;
	private static long getNthPrime(long N) {
		while(primeNumbers.size()<N){
			
			if(!isDivisibleByLowerPrimes(currentNumber)){
				primeNumbers.add(currentNumber);
			}
			currentNumber = currentNumber+2;
		}
		return primeNumbers.get((int) (N-1));
	}

	private static boolean isDivisibleByLowerPrimes(int number) {
		int squareRoot = (int) Math.sqrt(number);
		for(Integer i:primeNumbers){
			if(i>squareRoot){
				return false;
			}
			if(number%i.intValue()==0){
				return true;
			}
		}
		return false;
	}

}
