package InterviewBit.dynamic;

public class PartisionSameAvg {
	public static void main(String[] args) {

		PartisionSameAvg p = new PartisionSameAvg();
		System.out.println(p.splitArraySameAverage(new int[] { 3, 1, 2 }));

	}

	public boolean splitArraySameAverage(int[] a) {
		int n = a.length;
		if (n == 0) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		int dp[][] = new int[sum + 1][n];
		int b = -1;
		for (int i = 0; i <= sum && b == -1; i++) {
			for (int j = 0; j < n; j++) {

				if (i == a[j]) {
					dp[i][j] = 1;
					if (findAvg(sum, n, i, 1)) {
						b = dp[i][j];
						break;
					}
				}
				if (j > 0 && i - a[j] >= 0 && dp[i - a[j]][j - 1] != 0) {
					dp[i][j] = dp[i - a[j]][j - 1] + 1;
					if (findAvg(sum, n, i, dp[i][j])) {
						b = dp[i][j];
						break;
					}
				}
				if (j > 0 && dp[i][j - 1] != 0) {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}

		if (b == -1 || b == n) {
			return false;
		} else {
			return true;
		}
	}

	private boolean findAvg(int a, int b, int c, int d) {
		if (b == 0 || d == 0) {
			return false;
		}
		return (((1.0) * a) / b) == (((1.0) * c) / d);

	}
}
