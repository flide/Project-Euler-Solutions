package problems._10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		/*
		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		List<Integer> listOfTestCases = new ArrayList<>();
		for(int i = 0; i < numberOfTestCases; i++){
			int N = in.nextInt();
			listOfTestCases.add(N);
		}
		
		for(Integer testCase: listOfTestCases){
			long result = getSumOfPrimesSmallerThanN(testCase.intValue());
			System.out.println(result);
		}
		in.close();
		*/
		long result = getSumOfPrimesSmallerThanN(2000000);
		System.out.println(result);

	}

	private static long getSumOfPrimesSmallerThanN(int N) {
		long sum = 0;
		int currentPrimeSerialNumber = 1;
		long currentPrime = getNthPrime(currentPrimeSerialNumber);
		while(currentPrime <= N){
			sum = sum + currentPrime;
			currentPrimeSerialNumber++ ;
			currentPrime = getNthPrime(currentPrimeSerialNumber);
		}
		return sum;
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
