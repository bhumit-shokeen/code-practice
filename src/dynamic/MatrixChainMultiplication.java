//https://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
package dynamic;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
		System.out.println(matrixChainMultiplication.sol(new int[] { 10, 20, 30 }));
	}

	private int sol(int[] input) {

		int[][] dp = new int[input.length - 1][input.length - 1];

		for (int i = 0; i < input.length - 2; i++) {
			dp[i][i + 1] = input[i] * input[i + 1] * input[i + 2];
			dp[i][i] = 0;
		}
		int min;
		int ans = 0;

		for (int o = 0; o < dp.length - 2; o++) {
			int i = 0;
			int j = o + 2;
			while (j < dp.length) {
				min = Integer.MAX_VALUE;
				for (int k = i + 1; k <= j; k++) {
					ans = dp[i][k - 1] + dp[k][j] + (input[i] * input[k] * input[j + 1]);
					if (ans < min) {
						min = ans;
					}
				}
				dp[i][j] = min;
				j++;
				i++;

			}

		}
		/*
		 * for (int i = 0; i < dp.length - 2; i++) { for (int j = i + 2; j <
		 * dp.length; j++) { min = Integer.MAX_VALUE; for (int k = i + 1; k <=
		 * j; k++) { ans = dp[i][k - 1] + dp[k][j] + (input[i] * input[k] *
		 * input[j + 1]); if (ans < min) { min = ans; } } dp[i][j] = min;
		 * 
		 * }
		 * 
		 * }
		 */

		for (int i = 0; i < dp.length; i++) {
			System.out.println("");
			for (int j = 0; j < dp.length; j++) {
				System.out.print(" " + dp[i][j]);
			}
		}
		return 0;
	}

}
