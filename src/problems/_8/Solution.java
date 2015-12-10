package problems._8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class InputStructure {

	public int N;
	public int K;
	public String NdigitNumber;
	
	public InputStructure(int n, int k, String ndigitNumber) {
		N = n;
		K = k;
		NdigitNumber = ndigitNumber;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		List<InputStructure> listOfTestCases = new ArrayList<>();
		for(int i = 0; i < numberOfTestCases; i++){
			int N = in.nextInt();
			int K = in.nextInt();
			String number = in.next();
			listOfTestCases.add(new InputStructure(N, K, number));
		}
		
		for(InputStructure testCase: listOfTestCases){
			long result = getGreatestProductOfConsecutiveDigits(testCase.N, testCase.K, testCase.NdigitNumber);
			System.out.println(result);
		}
		in.close();

	}

	private static long getGreatestProductOfConsecutiveDigits(int n, int k, String ndigitNumber) {
		if(k>n){
			return 0;
		}
		List<String> numberChunk = new ArrayList<>(Arrays.asList(ndigitNumber.split("0")));
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i<numberChunk.size(); i++){
			if(numberChunk.get(i).length()>=k){
				for(int j = 0; j<=numberChunk.get(i).length()-k; j++){
					String kConsecutiveDigitNumber = numberChunk.get(i).substring(j, j+k);
					char[] chars = kConsecutiveDigitNumber.toCharArray();
					Arrays.sort(chars);
					set.add(new String(chars));
				}
				
			}
		}

		if(set.size() == 0){
			return 0;
		}
		List<String> kConsecutiveDigitList = new ArrayList<>();
		for(String temp: set){
			kConsecutiveDigitList.add(temp);
		}

		Collections.sort(kConsecutiveDigitList);
		long result = 0;
		for(String currentString: kConsecutiveDigitList){
			long productOfDigits = getProductOfDigits(currentString); 
			if(result < productOfDigits){
				result = productOfDigits;
			}
		}
		
		return result;
	}

	public static long getProductOfDigits(String number){
		long result = 1;
		for(int i = 0; i<number.length(); i++){
			char[] digit = {number.charAt(i)};
			result = result * Long.parseLong(new String(digit));
		}
		return result;
	}
}
