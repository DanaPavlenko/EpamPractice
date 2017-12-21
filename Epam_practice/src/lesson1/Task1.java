package lesson1;

import java.math.BigInteger;

public class Task1 {

	public static void main(String[] args) {
		fibonacci(10000);
	}

	// output 10000 first elements of fibonacci row
	public static void fibonacci(int count) {
		BigInteger number1 = BigInteger.valueOf(0);
		BigInteger number2 = BigInteger.valueOf(1);
		for (int i = 0; i < count; i++) {
			if (i < 1)
				System.out.println(number2);
			else {
				BigInteger sum = BigInteger.valueOf(0);
				sum = number1.add(number2);
				System.out.println(sum);
				number1 = number2;
				number2 = sum;
			}
		}
	}
}

