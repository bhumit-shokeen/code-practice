package InterviewBit.dynamic;

public class Sum {
	public static void main(String[] args) {
		Sum sum = new Sum();
		System.out.println(sum.solve(2, 2));
	}

	public int solve1(int a, int b) {

		return find(a, b, 1);
	}

	public int solve(int a, int b) {
		int[][] dp = new int[a + 1][b + 1];

		for (int j = 0; j < 10 && j <= b; j++) {
			dp[0][j] = 0;
			dp[1][j] = 1;
		}
		for (int j = 0; j <= a; j++) {
			dp[j][0] = 0;
		}
		for (int j = 2; j < dp.length; j++) {
			for (int k = 0; k <= b; k++) {
				for (int l = 0; l < 10; l++) {
					if (k - l < 0) {
						continue;
					}
					dp[j][k] = ((dp[j][k] % 1000000007) + (dp[j - 1][k - l] % 1000000007)) % 1000000007;
				}
			}
		}
		return dp[a][b];

	}

	private int find(int a, int b, int i) {
		int sol = 0;
		if (b < 0 | i > a) {
			return sol;
		}

		for (int j = 0; j < 10; j++) {
			if (j == 0 && i == 1) {
				continue;
			}
			if (a == i && b == j) {
				return ((sol % 1000000007) + 1) % 1000000007;
			}
			sol = ((sol % 1000000007) + (find(a, b - j, i + 1)) % 1000000007) % 1000000007;

		}
		return sol;
	}
}
