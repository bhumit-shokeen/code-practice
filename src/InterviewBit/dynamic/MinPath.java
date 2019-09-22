package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class MinPath {
	public static void main(String[] args) {
		MinPath minPath = new MinPath();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList(Arrays.asList(1, 3, 2)));
		input.add(new ArrayList(Arrays.asList(4, 3, 1)));
		input.add(new ArrayList(Arrays.asList(5, 6, 1)));
		System.out.println(minPath.minPathSum(input));
	}

	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(m - 1).size();

		int[][] dp = new int[m][n];

		dp[m - 1][n - 1] = a.get(m - 1).get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = a.get(m - 1).get(i) + dp[m - 1][i + 1];
		}
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = a.get(i).get(n - 1) + dp[i + 1][n - 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = a.get(i).get(j) + Math.min(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		return dp[0][0];
	}
}
