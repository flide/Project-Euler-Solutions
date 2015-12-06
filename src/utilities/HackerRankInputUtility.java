package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HackerRankInputUtility {

	/*
	 * Copy Paste code for the Hacker Rank Website, instead of calling the utility functions
	 
	 	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		long numberOfTestCases = Integer.parseInt(line);
		List<Long> listOfTestCases = new ArrayList<>();
		for(int i = 0; i < numberOfTestCases; i++){
			line = stdin.readLine();
			listOfTestCases.add(Long.parseLong(line));
		}
	 */
	
	private static final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	private static int getNumberOfTestCases() throws IOException{
		
		String line = stdin.readLine();
		int numberOfTestCases = Integer.parseInt(line);
		
		return numberOfTestCases;
	}
	
	public static List<Long> getListOfTestCases() throws IOException{
		int numberOfTestCases = HackerRankInputUtility.getNumberOfTestCases();
		List<Long> listOfN = new ArrayList<>();
		String line;
		for(int i = 0; i < numberOfTestCases; i++){
			line = stdin.readLine();
			listOfN.add(Long.parseLong(line));
		}
		
		return listOfN;
	}
}
