package InterviewBit.dynamic;

public class Scramble {
	public static void main(String[] args) {
		Scramble scramble = new Scramble();
		System.out.println(scramble.isScramble("qmfcwwzb", "wfcmbzwq"));
	}

	public int isScramble(final String a, final String b) {
		if (a.length() != b.length())
			return 0;
		int dp[][][] = new int[b.length()][b.length()][b.length() + 1];
		return isValid(a, 0, b, 0, b.length(), dp) ? 1 : 0;

	}

	private boolean isValid(String a, int s1, String b, int s2, int l, int[][][] dp) {
		if (l == 1) {
			if (a.charAt(s1) == b.charAt(s2)) {
				dp[s1][s2][l] = 1;
				// System.out.println(s1 + " " + s2 + " " + l + " = " +
				// dp[s1][s2][l]);
				return true;
			}

		}
		for (int i = 1; i < l; i++) {
			if ((dp[s1][s2][i] == 1 ? true : dp[s1][s2][i] == 2 ? false : isValid(a, s1, b, s2, i, dp))
					&& (dp[s1 + i][s2 + i][l - i] == 1 ? true
							: dp[s1 + i][s2 + i][l - i] == 2 ? false : isValid(a, s1 + i, b, s2 + i, l - i, dp))) {
				dp[s1][s2][l] = 1;
				// System.out.println(s1 + " " + s2 + " " + l + " = " +
				// dp[s1][s2][l]);
				return true;
			}
			if ((dp[s1][s2 + l - i][i] == 1 ? true
					: dp[s1][s2 + l - i][i] == 2 ? false : isValid(a, s1, b, s2 + l - i, i, dp))
					&& (dp[s1 + i][s2][l - i] == 1 ? true
							: dp[s1 + i][s2][l - i] == 2 ? false : isValid(a, s1 + i, b, s2, l - i, dp))) {
				dp[s1][s2][l] = 1;
				// System.out.println(s1 + " " + s2 + " " + l + " = " +
				// dp[s1][s2][l]);
				return true;
			}

		}
		dp[s1][s2][l] = 2;
		// System.out.println(s1 + " " + s2 + " " + l + " = " + dp[s1][s2][l]);
		return false;
	}
}
