package InterviewBit.dynamic;

public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString interleavingString = new InterleavingString();
		System.out.println(interleavingString.isInterleave("cwwi", "wcwi", "cwwcwiwi"));
		System.out.println(interleavingString.isInterleave("sblIWKBF9yT3sAw4", "OxRZnGzMeMJ7ZCwidxBSTDyaNj1D",
				"OsxblRZnGIWKzBF9yTMyaNj1D"));
		// System.out.println(interleavingString.isInterleave("b", "e", "be"));
	}

	public int isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return 0;
		}
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= s2.length(); i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1] == 1)
				dp[0][i] = 1;
		}
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] == 1)
				dp[i][0] = 1;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j] == 1) {
					dp[i][j] = 1;
				} else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1] == 1) {
					dp[i][j] = 1;
				}
			}
			int test = Integer.valueOf(i);
		}
		return dp[s1.length()][s2.length()];
	}
}
