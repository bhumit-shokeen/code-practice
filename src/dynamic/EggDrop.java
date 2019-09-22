//https://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
package dynamic;

import java.util.Scanner;

public class EggDrop {
	public static void main(String[] args) {
		EggDrop eggDrop = new EggDrop();
		Scanner s = new Scanner(System.in);
		int n, k;
		int t = s.nextInt(); // Reading input from STDIN
		while (t-- > 0) {
			n = s.nextInt();
			k = s.nextInt();
			// System.out.println(eggDrop.sol(n, k));
			System.out.println(eggDrop.solDp(n, k));
		}

	}

	private int solDp(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= k; i++) {
			dp[0][i] = 0;
			dp[1][i] = i;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		int sol = Integer.MAX_VALUE;
		int temp;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				sol = Integer.MAX_VALUE;
				for (int g = 1; g <= j; g++) {
					temp = 1 + Integer.max(dp[i - 1][g - 1], dp[i][j - g]);
					if (temp < sol) {
						sol = temp;
						dp[i][j] = sol;
					}
				}

			}
		}

		return dp[n][k];
	}

	private int sol(int n, int k) {
		// System.out.println(n + " " + k);
		if (n == 0) {
			return 0;
		}
		if (k == 0 || k == 1) {
			return k;
		}
		if (n == 1) {
			return k;
		}
		int sol = Integer.MAX_VALUE;
		int temp;
		for (int i = 1; i <= k; i++) {
			temp = 1 + Integer.max(sol(n - 1, i - 1), sol(n, k - i));
			if (temp < sol) {
				sol = temp;
			}
		}

		return sol;
	}
}
