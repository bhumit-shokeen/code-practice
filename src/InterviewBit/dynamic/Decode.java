package InterviewBit.dynamic;

public class Decode {
	public static void main(String[] args) {
		Decode decode = new Decode();
		System.out.println(decode.numDecodingsR("875361268549483279131"));
	}

	public int numDecodingsR(String b) {

		int n = b.length();
		if (n == 0) {
			return 0;
		}
		char[] a = b.toCharArray();
		if (a[0] == '0') {
			return 0;
		}

		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (a[i - 1] == '0') {
				if (a[i - 2] == '1' || a[i - 2] == '2') {
					dp[i] += dp[i - 2];
				} else {
					return 0;
				}
			} else {
				if (i > 1 && (a[i - 2] == '1' || (a[i - 2] == '2' && a[i - 1] <= '6'))) {
					dp[i] += dp[i - 1] + dp[i - 2];
				} else {
					dp[i] += dp[i - 1];
				}
			}

		}

		return dp[n];

	}

	public int numDecodings(String a) {
		if (a == null || a.length() == 0 || a.charAt(0) == '0') {
			return 0;
		}
		int[] dp = new int[a.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			if (a.charAt(i - 1) == '0') {
				if (a.charAt(i - 2) != '1' && a.charAt(i - 2) != '2') {
					return 0;
				} else {
					dp[i] = dp[i - 2];
				}

			} else {
				if ((a.charAt(i - 2) == '1') || (a.charAt(i - 2) == '2' && a.charAt(i - 1) < '7')) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else {
					dp[i] = dp[i - 1];
				}
			}

		}
		return dp[a.length()];
	}

	public int numDecodings1(String a) {
		int[] dp = new int[a.length() + 1];
		dp[0] = 1;
		if (a.charAt(0) == '0') {
			return 0;
		}
		dp[1] = 1;
		for (int i = 1; i < dp.length - 1; i++) {
			if (a.charAt(i) != '0') {
				if ((a.charAt(i - 1) == '1') || ((a.charAt(i - 1) == '2') && (a.charAt(i) < '7'))) {
					dp[i + 1] = dp[i] + dp[i - 1];
				} else {
					dp[i + 1] = dp[i];
				}

			} else {
				if (a.charAt(i - 1) == '1' || a.charAt(i - 1) == '2') {
					dp[i + 1] = dp[i - 1];
				} else {
					return 0;
				}
			}
		}

		return dp[a.length()];

	}
}
