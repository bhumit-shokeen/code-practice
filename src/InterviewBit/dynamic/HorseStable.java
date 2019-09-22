package InterviewBit.dynamic;

public class HorseStable {
	public static void main(String[] args) {
		HorseStable horseStable = new HorseStable();
		System.out.println(horseStable.arrange("BWWWW", 3));
	}
	// BWBWWWWBWBBWBWBW , 4

	// BWBBBWBWBW, 4

	public int arrange(String A, int b) {
		int n = A.length();
		if (b > n) {
			return -1;
		}
		char[] a = A.toCharArray();
		int[][] dp = new int[b][n];

		int blackCount = 0;
		int whiteCount = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == 'B') {
				blackCount++;
			}
			if (a[i] == 'W') {
				whiteCount++;
			}
			dp[0][i] = findCost(blackCount, whiteCount);
		}

		for (int i = 1; i < b; i++) {
			// System.out.println("");
			for (int j = i; j < n; j++) {
				if (i == j) {
					dp[i][j] = 0;
				} else {
					int tempSol = Integer.MAX_VALUE;
					int bC = (a[j] == 'B' ? 1 : 0);
					int wC = (a[j] == 'W' ? 1 : 0);
					for (int k = j - 1; k >= i - 1; k--) {
						if (tempSol > dp[i - 1][k] + findCost(bC, wC)) {
							tempSol = dp[i - 1][k] + findCost(bC, wC);

						}
						bC = bC + (a[k] == 'B' ? 1 : 0);
						wC = wC + (a[k] == 'W' ? 1 : 0);

					}
					dp[i][j] = tempSol;
				}
				// System.out.print(dp[i][j].cost + " " + dp[i][j].white + " " +
				// dp[i][j].black + " ");
			}
		}
		for (int i = 0; i < b; i++) {
			System.out.println("");

			for (int j = 0; j < dp[0].length; j++) {
				if (j < i) {
					System.out.print(" -: " + "-");
				} else
					System.out.print(" c: " + dp[i][j]);
			}
		}
		return dp[b - 1][n - 1];
	}

	private int findCost(int b, int w) {
		if (b == 0 || w == 0) {
			return 0;
		}

		return b * w;
	}
}
