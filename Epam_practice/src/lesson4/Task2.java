package lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		List<String> lines = input();
		int maxLength = findMaxLength(lines);
		rightJustify(lines, maxLength);
	}

	public static List<String> input() {

		System.out.println("Enter string");
		List<String> lines = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String current = sc.nextLine();
			if (current.equals(""))
				break;
			lines.add(current);
		}
		sc.close();
		return lines;
	}

	public static int findMaxLength(List<String> lines) {

		int max = 0;
		for (String line : lines) {
			if (line.length() > max)
				max = line.length();
		}
		return max;
	}

	public static void rightJustify(List<String> lines, int max) {

		for (String line : lines) {
			System.out.printf("%" + max + "s%n", line);
		}
	}
}
