package problems._2;

import java.io.IOException;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {

	public static void main(String[] args) throws IOException {
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long largestPrimeFactor = findTheSumOfEvenFibonaciTermsLessThan(testCase.longValue());
			System.out.println(largestPrimeFactor);
		}                                              		
	}

	private static long findTheSumOfEvenFibonaciTermsLessThan(long N) {
		
		long firstTerm = 2L;
		long secondTerm = 8L;
		
		if(N<firstTerm){
			return 0L;
		} else if(N<secondTerm){
			return 2;
		}
		long largestTermBelowN = secondTerm;
		long secondLargestTermBelowN = firstTerm;
		long currentTerm = 4*largestTermBelowN + secondLargestTermBelowN;
		while(currentTerm < N){
			
			secondLargestTermBelowN = largestTermBelowN;
			largestTermBelowN = currentTerm;
			currentTerm = 4*largestTermBelowN + secondLargestTermBelowN;	
		}
		
		long sumOfEvenTerms = (((5*largestTermBelowN)+(secondLargestTermBelowN)-2)/4);
		return sumOfEvenTerms;
	}
}
