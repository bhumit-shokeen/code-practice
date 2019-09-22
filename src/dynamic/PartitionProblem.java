//https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
package dynamic;

public class PartitionProblem {
	public static void main(String[] args) {
		PartitionProblem partitionProblem = new PartitionProblem();
		// System.out.println(partitionProblem.sol(new int[] { 1, 5, 11, 5 }, 0,
		// 0, 0));
		System.out.println(partitionProblem.solDp(new int[] { 3, 1, 5, 9, 12 }));
	}

	private int solDp(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		if (sum % 2 != 0) {
			return 0;
		}
		int[][] dp = new int[a.length + 1][sum / 2 + 1];
		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= sum / 2; j++) {
				if (dp[i][j] == 0) {

					if (j == 0) {
						dp[i][j] = 1;
					} else if (i == 0) {
						continue;
					} else if (a[i - 1] == j) {
						for (int k = i; k <= +a.length; k++) {
							dp[k][j] = 1;
						}
					} else if (j - a[i - 1] >= 0) {
						if (dp[i - 1][j - a[i - 1]] == 1) {
							for (int k = i; k <= +a.length; k++) {
								dp[k][j] = 1;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i <= a.length; i++) {
			System.out.println("");
			for (int j = 0; j <= sum / 2; j++) {
				System.out.print(" " + dp[i][j]);
			}
		}

		return dp[a.length][sum / 2];
	}

	private boolean sol(int[] input, int i, int sum1, int sum2) {
		if (i == input.length) {
			if (sum1 == sum2) {
				return true;
			} else
				return false;
		}
		return (sol(input, i + 1, sum1 + input[i], sum2) || sol(input, i + 1, sum1, sum2 + input[i]));
	}
}
