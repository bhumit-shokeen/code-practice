package InterviewBit.dynamic;

public class DistinctSubsequence {
	public static void main(String[] args) {
		DistinctSubsequence subsequence = new DistinctSubsequence();
		System.out.println(subsequence.numDistinct("rbbbi", "rbbi"));
	}

	public int numDistinct(String a, String b) {
		int n = a.length();
		int m = b.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m && j <= i; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}

		}

		return dp[n][m];
	}
}
