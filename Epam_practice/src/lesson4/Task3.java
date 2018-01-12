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
		System.out.println("Last letters:");
		System.out.println(lastLetters);
	}

	public static String[] inputAndCreateRotations() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string:");
		String form = sc.next();
		String[] rotations = new String[form.length()];
		for (int i = 0; i < form.length(); i++) {
			rotations[i] = form;
			form = form.substring(1, form.length()) + form.substring(0, 1);
		}
		System.out.println();
		sc.close();
		return rotations;
	}

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

	public static String takeLastLetters(String[] sortedRotations) {

		String lastLettets = new String();
		for (int i = 0; i < sortedRotations.length; i++) {
			lastLettets += sortedRotations[i].charAt(sortedRotations[i].length() - 1);
		}
		return lastLettets;
	}

	public static void output(String[] rotations) {
		for (int i = 0; i < rotations.length; i++) {
			System.out.println(rotations[i]);
		}
		System.out.println();
	}
}
