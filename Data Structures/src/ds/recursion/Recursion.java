package ds.recursion;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.sql.Timestamp;
import java.util.regex.*;

//Program to print all possible words from a set of given characters

public class Recursion {

	List<String> wordList = new ArrayList<String>();

	public int fact(int n) {

		if (n == 1)
			return 1;
		else
			n = n * fact(n - 1);

		return n;

	}

	public void formWordsWithoutRecursion() {

		char[] charInput = { 'a', 'b', 'c', 'd', 'e', 'f' };

		int length = charInput.length;
		boolean[] used = new boolean[length];

		for (int i = 0; i < length; i++) {
			used[i] = true;

			for (int j = 0; j < length; j++) {
				if (used[j] == true)
					continue;
				else
					used[j] = true;

				for (int k = 0; k < length; k++) {
					if (used[k] == true)
						continue;
					else
						used[k] = true;

					for (int list = 0; list < length; list++) {
						if (used[list] == true)
							continue;
						else
							used[list] = true;

						for (int m = 0; m < length; m++) {
							if (used[m] == true)
								continue;
							else
								used[m] = true;

							for (int n = 0; n < length; n++) {
								if (used[n] == true)
									continue;
								else
									used[n] = true;

								System.out.println(charInput[i] + "" + charInput[j] + "" + charInput[k] + ""
										+ charInput[list] + "" + charInput[m] + "" + charInput[n]);

								used[n] = false;
							}
							used[m] = false;
						}
						used[list] = false;
					}
					used[k] = false;
				}
				used[j] = false;
			}
			used[i] = false;
		}
	}

	public void recursionUsingBoolean(String[] input, boolean[] used, StringBuffer word) {

		if (word.length() == input.length) {
			// System.out.println(word);
		}

		for (int i = 0; i < input.length; i++) {

			if (used[i] == true)
				continue;

			used[i] = true;
			word.append(input[i]);
			recursionUsingBoolean(input, used, word);

			used[i] = false;
			word.setLength(word.length() - 1);

		}
	}

	public String[] recursionDBCseparately(String input) {

		if (input.length() == 1) {
			String[] s = new String[input.length()];
			s[0] = input;
			return s;
		}

		else {

			int k = 0;
			String[] solution = new String[fact(input.length())];

			for (int i = 0; i < input.length(); i++) {

				String subString = "";
				for (int j = 0; j < input.length(); j++)
					if (j == i)
						continue;
					else
						subString = subString + input.charAt(j);

				String[] smallSolution = new String[subString.length()];
				smallSolution = recursionDBCseparately(subString);

				for (int j = 0; j < smallSolution.length; j++) {
					solution[k] = smallSolution[j] + input.charAt(i);
					k++;
				}

			}
			return solution;
		}

	}

	public void recursionUsingSwap(String[] input, int position, int length) {

		if (position == length) {

			for (int i = 0; i < length; i++) {
			}
			// System.out.print(input[i]);

			// System.out.println();
		}

		else {

			for (int i = position; i < length; i++) {

				String j = input[position];
				input[position] = input[i];
				input[i] = j;

				recursionUsingSwap(input, (position + 1), length);

				j = input[position];
				input[position] = input[i];
				input[i] = j;

			}

		}

	}

	public void recursionDBCsimultaneous(String input, String word) {

		if (input.isEmpty()) {
			if (!wordList.contains(word.subSequence(2, 5).toString()))
				wordList.add(word.subSequence(2, 5).toString());
			System.out.println(word.subSequence(2, 5));
		} else {

			for (int i = 0; i < input.length(); i++) {

				String smallProblem = "";
				String smallSolution = "";

				for (int j = 0; j < input.length(); j++)
					if (j == i)
						smallSolution = word + input.charAt(j);
					else
						smallProblem += input.charAt(j);

				recursionDBCsimultaneous(smallProblem, smallSolution);

			}
		}
	}

	public static void main(String[] args) {

		Recursion rec = new Recursion();

		String[] inputArray = { "a", "b", "c", "d", "e" };

		// "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"

		String inputString = "bathe";

		// abcdefghij

		int length = inputArray.length;
		boolean[] used = new boolean[length];
		StringBuffer word = new StringBuffer();
		double startTime, endTime;

		// Recursion Using Boolean

		System.out.println("Recursion Using Boolean");

		startTime = System.currentTimeMillis();
		// rec.recursionUsingBoolean(inputArray, used, word);
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime - startTime));

		// Recursion DBC separately

		System.out.println("\nRecursion DBC separately");

		startTime = System.currentTimeMillis();
		// ds.recursion.recursionDBCseparately(inputString);
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime - startTime));

		// Recursion Using Swap

		System.out.println("\nRecursion Using Swap");

		startTime = System.currentTimeMillis();
		// rec.recursionUsingSwap(inputArray, 0, length);
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime - startTime));

		// Recursion DBC simultaneous

		System.out.println("\nRecursion DBC simultaneous");

		String wordString = new String();
		startTime = System.currentTimeMillis();
		rec.recursionDBCsimultaneous(inputString, wordString);
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken " + (endTime - startTime));

		System.out.println(rec.wordList.size());
	}
}
