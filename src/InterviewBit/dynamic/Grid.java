package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
	public static void main(String[] args) {
		Grid grid = new Grid();

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList(Arrays.asList(0, 0, 0)));
		input.add(new ArrayList(Arrays.asList(0, 1, 0)));
		input.add(new ArrayList(Arrays.asList(0, 0, 0)));
		System.out.println(grid.uniquePathsWithObstacles(input));
	}

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(m - 1).size();

		int[][] dp = new int[m][n];

		dp[m - 1][n - 1] = a.get(m - 1).get(n - 1) == 1 ? 0 : 1;
		int sol = dp[m - 1][n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (sol == 0) {
				dp[m - 1][i] = 0;
			} else if (a.get(m - 1).get(i) == 1) {
				dp[m - 1][i] = 0;
				sol = 0;
			} else {
				dp[m - 1][i] = 1;
			}

		}
		sol = dp[m - 1][n - 1];
		for (int i = m - 2; i >= 0; i--) {
			if (sol == 0) {
				dp[i][n - 1] = 0;
			} else if (a.get(i).get(n - 1) == 1) {
				dp[i][n - 1] = 0;
				sol = 0;
			} else {
				dp[i][n - 1] = 1;
			}
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (a.get(i).get(j) == 0) {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}
		return dp[0][0];
	}
}
