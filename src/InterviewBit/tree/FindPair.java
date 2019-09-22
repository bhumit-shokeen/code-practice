package InterviewBit.tree;

import java.util.HashSet;

public class FindPair {

	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		return sol(set, root, k);

	}

	private boolean sol(HashSet<Integer> set, TreeNode root, int k) {
		if (root != null) {
			if (set.contains(root.val)) {
				return true;
			} else {
				set.add(k - root.val);
			}
			boolean one = sol(set, root.left, k);
			boolean two = sol(set, root.right, k);
			return (one || two);
		}
		return false;
	}

	public String gcdOfStrings(String a, String b) {
		int n = a.length();
		int m = b.length();
		int index = -1;
		int sol = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					if (sol < dp[i][j]) {
						sol = dp[i][j];
						index = i;
					}
				}
			}
		}
		if (sol != 0) {
			return a.substring(index - sol, index);
		}
		return "";
	}

}
