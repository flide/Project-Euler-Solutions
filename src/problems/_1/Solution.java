package problems._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		long numberOfTestCases = Integer.parseInt(line);
		List<Long> listOfN = new ArrayList<>();
		for(int i = 0; i < numberOfTestCases; i++){
			line = stdin.readLine();
			listOfN.add(Long.parseLong(line));
		}
		
		for(int i=0; i<numberOfTestCases; i++){
			long N = listOfN.get(i);
			long sumOfMultiplesOf3LessThanN = getSumOfMultiplesOfXLessThanN(3,N);
			long sumOfMultiplesOf5LessThanN = getSumOfMultiplesOfXLessThanN(5,N);
			long sumOfMultiplesOf15LessThanN = getSumOfMultiplesOfXLessThanN(15,N);
			System.out.println(sumOfMultiplesOf3LessThanN + sumOfMultiplesOf5LessThanN - sumOfMultiplesOf15LessThanN);
		}
		
		
	}

	private static long getSumOfMultiplesOfXLessThanN(long x, long n) {
		long numberOfMultiples = (n-1)/x;
		long sumOfMultiplesOfXLessThanN = x*(((numberOfMultiples)*(numberOfMultiples+1))/2);
		return sumOfMultiplesOfXLessThanN;
	}

}
