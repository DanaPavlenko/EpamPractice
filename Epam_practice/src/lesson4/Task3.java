package lesson4;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {

		String[] rotations = inputAndCreateRotations();
		System.out.println("Rotations:");
		output(rotations);
		String[] sortedRotations = sort(rotations);
		System.out.println("Sorted rotations:");
		output(sortedRotations);
		String lastLetters = takeLastLetters(sortedRotations);
		System.out.println("Last letters: " + lastLetters);
	}

	// input word and create array of rotations
	public static String[] inputAndCreateRotations() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String word = sc.next();
		String[] rotations = new String[word.length()];
		for (int i = 0; i < word.length(); i++) {
			rotations[i] = word;
			word = word.substring(1, word.length()) + word.substring(0, 1);
		}
		System.out.println();
		sc.close();
		return rotations;
	}

	// bubble sort of rotations in alphabet order
	public static String[] sort(String[] rotations) {
		for (int i = rotations.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (rotations[j].compareTo(rotations[j + 1]) > 0) {
					String tmp = rotations[j];
					rotations[j] = rotations[j + 1];
					rotations[j + 1] = tmp;
				}
			}
		}
		return rotations;
	}

	// take last letters of every rotation and write them in String object
	public static String takeLastLetters(String[] sortedRotations) {

		String lastLettets = new String();
		for (int i = 0; i < sortedRotations.length; i++) {
			lastLettets += sortedRotations[i].charAt(sortedRotations[i].length() - 1);
		}
		return lastLettets;
	}

	// output array of rotations
	public static void output(String[] rotations) {
		for (int i = 0; i < rotations.length; i++) {
			System.out.println(rotations[i]);
		}
		System.out.println();
	}
}
