package lesson1;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		int mas[] = new int[5];
		enterData(mas);
		System.out.println("Array:");
		print(mas);
		sort(mas);
		System.out.println("Sorted array:");
		print(mas);
		System.out.println("Elements with digits in growth order:");
		growthOrder(mas);
		System.out.println("Elements with simple digits:");
		simpleNumerals(mas);
		System.out.println("Elements which divide on previous:");
		dividePrevious(mas);
	}

	// input 5 numbers with at least 5 numerals and write them in array
	public static void enterData(int mas[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 5 numbers");
		int i = 0;
		while (i < 5) {
			int number = sc.nextInt();
			if (number >= 10000 || number <= -10000) {
				mas[i] = number;
				i++;
			} else
				System.out.println("Enter number with 5 digits at least");
		}
		sc.close();
	}

	//sort array
	public static void sort(int mas[]) {
		for (int i = mas.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (mas[j] > mas[j + 1]) {
					int tmp = mas[j];
					mas[j] = mas[j + 1];
					mas[j + 1] = tmp;
				}
			}
		}
	}
    //output numbers with digits in growth order
	public static void growthOrder(int mas[]) {
		for (int i = 0; i < mas.length; i++) {
			int temp = Math.abs(mas[i]);
			while (temp >= 10) {
				if (temp % 10 > (temp / 10) % 10)
					temp /= 10;
				else
					break;
			}
			if (temp < 10)
				System.out.print(mas[i] + " ");
		}
		System.out.println();
	}
	
    //output numbers with simple digits
	public static void simpleNumerals(int mas[]) {
		for (int i = 0; i < mas.length; i++) {
			int temp = Math.abs(mas[i]);
			while (temp >= 10) {
				int number = temp % 10;
				if ((number > 3 || number == 0) && (number % 2 == 0 || number % 3 == 0)) {
					temp /= 10;
				} else {
					System.out.print(mas[i] + " ");
					break;
				}
			}
		}
		System.out.println();
	}

	//output numbers which divide on previous
	public static void dividePrevious(int mas[]) {
		for (int i = 1; i < mas.length; i++) {
			{
				if (mas[i] % mas[i - 1] == 0)
					System.out.print(mas[i] + " ");
			}
		}
		System.out.println();
	}

	//output array
	public static void print(int mas[]) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
		System.out.println();
	}
}

