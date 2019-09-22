package InterviewBit;

public class AntiDiagonal {
	public static void main(String[] args) {
		AntiDiagonal antiDiagonal = new AntiDiagonal();
		int sol[][] = antiDiagonal.diagonal(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		for (int i = 0; i < sol.length; i++) {
			System.out.println("");
			for (int j = 0; j < sol[i].length; j++) {
				System.out.print(" " + sol[i][j]);
			}
		}
	}

	public int[][] diagonal(int[][] a) {
		int n = a.length;
		int r = 0;
		int c = 0;
		int[][] ret = new int[2 * n - 1][];
		for (int i = 0; i < 2 * n - 1; i++) {
			if (i < n) {
				ret[i] = new int[i + 1];
			} else {
				ret[i] = new int[2 * n - i - 1];
			}
		}
		r = 0;
		c = 0;
		for (int i = 0; i < n; i++) {
			// System.out.println(" ");
			int j = 0;
			for (; j < n - i; j++) {
				// System.out.print(" " + a[i][j]);
				ret[r++][c] = a[i][j];
			}
			for (int l = i + 1; l < n; l++) {
				// System.out.print(" " + a[l][n - 1 - i]);
				ret[r++][c] = a[l][n - 1 - i];
			}
			c++;
			r = c;
		}

		return ret;
	}
}
