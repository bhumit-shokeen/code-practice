package InterviewBit.dynamic;

public class LCS {
	public static void main(String[] args) {
		LCS lCS = new LCS();
		System.out.println(lCS.anytwo("aaa"));
	}

	public int anytwo(String a) {
		int n = a.length();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				} else if (a.charAt(i - 1) == a.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n][n] > 1 ? 1 : 0;
	}
}
