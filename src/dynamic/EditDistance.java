package dynamic;

import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EditDistance editDistance = new EditDistance();
		int t = s.nextInt();
		String s1, s2;
		while (t-- > 0) {
			s1 = s.nextLine();
			s2 = s.nextLine();
			System.out.println(editDistance.ans(s1, s2));
		}

	}

	private char[] ans(String s1, String s2) {

		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();
		int[][] dp = new int[x.length + 1][y.length + 1];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				dp[i][j] = -1;
			}
		}

		int lcs = findLcs(x, y, x.length, y.length, dp);

		return null;
	}

	private int findLcs(char[] x, char[] y, int lenx, int leny, int[][] dp) {
		if (lenx > 0 && leny > 0) {
			if (x[lenx - 1] == y[leny - 1]) {

			}
		}

		return 0;
	}

}
