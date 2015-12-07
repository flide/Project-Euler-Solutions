package problems._5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long lcm = getLCMOfNaturalNumbersTill(testCase.longValue());
			System.out.println(lcm);
		}
	}

	private static long getLCMOfNaturalNumbersTill(long N) {
		List<Integer> primeNumbers = new ArrayList<>();
		long LCM = 1;
		for(int i = 2; i<=N; i++){
			if(!isDivisibleByLowerPrimes(i, primeNumbers)){
				LCM = LCM * findMaxMultiplier(i, N);
			}
		}
		return LCM;
	}

	private static long findMaxMultiplier(int i, long N) {
		long maxMultiplier = i;
		while(maxMultiplier*i <= N){
			maxMultiplier = maxMultiplier*i;
		}
		return maxMultiplier;
	}

	private static boolean isDivisibleByLowerPrimes(int number, List<Integer> primeNumbers) {
		for(Integer i:primeNumbers){
			if(number%i.intValue()==0){
				return true;
			}
		}
		primeNumbers.add(number);
		return false;
	}

}
