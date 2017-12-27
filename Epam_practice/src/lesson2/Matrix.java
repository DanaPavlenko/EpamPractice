package lesson2;

public class Matrix {

	static final int SIZE = 4;

	public static void main(String[] args) {
		Integer matrix[][] = new Integer[SIZE][SIZE];
		fillMatrix(matrix);
		print(matrix);
		sum(matrix);
	}

	// fill matrix with numbers from 1 to 10 above main diagonal; from 10 to 20 below it
	public static void fillMatrix(Integer matrix[][]) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i < j)
					matrix[i][j] = Integer.valueOf((int) (Math.round(Math.random() * 9 + 1)));
				else if (i > j)
					matrix[i][j] = Integer.valueOf((int) (Math.round(Math.random() * 10 + 10)));
				else
					matrix[i][j] = Integer.valueOf(0);
			}
		}
	}

	// count sum of numbers above main diagonal and below it
	public static void sum(Integer matrix[][]) {
		int aboveSum = 0;
		int belowSum = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i < j)
					aboveSum += matrix[i][j];
				else if (i > j)
					belowSum += matrix[i][j];
			}
		}
		System.out
				.println("Sum of elements above main diagonal is " + aboveSum + ", below main diagonal is " + belowSum);
	}

	// output matrix
	public static void print(Integer matrix[][]) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (matrix[i][j] < 10)
					System.out.print(" " + matrix[i][j] + " ");
				else
					System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
