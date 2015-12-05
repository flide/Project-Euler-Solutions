package problems._6;

import java.io.IOException;
import java.util.List;

import utilities.HackerRankInputUtility;

public class Solution {
	
	public static void main (String[] arg) throws IOException{
		List<Long> listOfTestCases = HackerRankInputUtility.getListOfTestCases();
		for(Long testCase: listOfTestCases){
			long sumSquareDifference = getSumSquareDifference(testCase);
			System.out.println(sumSquareDifference);
		}
		
	}

	private static long getSumSquareDifference(Long testCase) {
		long n = testCase.longValue();
		long sumSquareDifference =  (((n)*((long)(Math.pow(n, 2))-1)*((3*n)+2))/12);
		return sumSquareDifference;
	}
}
