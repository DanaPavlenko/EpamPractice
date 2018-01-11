package lesson4;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {

		StringBuffer text = input();
		deleteRepeatedLetters(text);

	}

	public static StringBuffer input() {

		System.out.println("Enter string and press twice key 'enter' to get the result:");
		StringBuffer text = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String current = sc.nextLine();
			if (current.equals(""))
				break;
			text.append(current).append("\n");
		}
		sc.close();
		return text;

	}

	public static void deleteRepeatedLetters(StringBuffer text) {

		for (int i = 0; i < text.length() - 1; i++) {
			if (text.charAt(i) == text.charAt(i + 1)) {
				text.deleteCharAt(i);
				i--;
			}

		}
		System.out.println(text);

	}
}
