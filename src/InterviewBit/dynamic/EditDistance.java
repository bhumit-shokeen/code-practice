package InterviewBit.dynamic;

public class EditDistance {
	public static void main(String[] args) {
		EditDistance editDistance = new EditDistance();
		System.out.println(editDistance.minDistance("Anshuman", "Antihuman"));
	}

	public int minDistance(String a, String b) {
		int dp[][] = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
					dp[i][j] += 1;
				}
			}
		}
		return dp[a.length()][b.length()];
	}
}
