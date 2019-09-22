package two;

public class MatrixSpiral {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		printSpiral(a);

	}

	private static void printSpiral(int[][] a) {

		int n = a.length;
		int m = a[0].length;
		int count = 0;
		int dir = 1;
		int block = 0;
		int i = 0;
		int j = 0;
		while (count < n * m) {
			if (dir == 1) {
				System.out.println(a[i][j]);
				j++;
				if (j == m - block - 1) {
					dir = 2;
				}
			} else if (dir == 2) {
				System.out.println(a[i][j]);
				i++;
				if (i == n - block - 1) {
					dir = 3;
				}

			} else if (dir == 3) {
				System.out.println(a[i][j]);
				j--;
				if (j == block) {
					dir = 4;
					block++;
				}

			} else if (dir == 4) {
				System.out.println(a[i][j]);
				i--;
				if (i == block) {
					dir = 1;

				}

			}
			count++;

		}

	}
}
