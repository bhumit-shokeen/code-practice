package InterviewBit.dynamic;

public class MinCut {
	public static void main(String[] args) {
		MinCut minCut = new MinCut();
		System.out.println(minCut.minCut("a"));
	}

	public int minCut(String a) {
		int n = a.length();
		int[][] dp = new int[n][n];
		int sol = n == 1 ? 0 : Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i + j + 1 < n; i++) {
				// System.out.println(i + " " + (i + j + 1));
				sol = j + 1;
				if (isPalin(a, i, i + j + 1)) {
					dp[i][i + j + 1] = 0;
					sol = 0;
				} else {
					for (int k = i; k < i + j + 1; k++) {
						sol = Math.min(sol, 1 + dp[i][k] + dp[k + 1][i + j + 1]);
					}
					dp[i][i + j + 1] = sol;
				}
			}

		}
		return sol;
	}

	private boolean isPalin(String a, int s, int e) {
		if (e < s) {
			return false;
		}
		while (e > s) {
			if (a.charAt(e) != a.charAt(s)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}
