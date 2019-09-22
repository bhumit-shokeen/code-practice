package InterviewBit.dynamic;

public class CountBst {
	public static void main(String[] args) {
		CountBst bst = new CountBst();
		System.out.println(bst.numTrees(10));
	}

	public int numTrees(int a) {
		int[] dp = new int[a + 1];
		dp[0] = 0;
		dp[1] = 1;
		return sol(1, a, dp);
	}

	private int sol(int s, int e, int[] dp) {
		if (s > e) {
			return 1;
		}
		if (s == e) {
			return 1;
		}
		int find = e - s + 1;
		if (dp[find] == 0) {

			int sol = 0;
			for (int i = s; i <= e; i++) {
				sol += sol(s, i - 1, dp) * sol(i + 1, e, dp);

			}
			dp[find] = sol;
		}
		return dp[find];

	}

}
