package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSum {
	public static void main(String[] args) {
		MaxSum maxSum = new MaxSum();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList(Arrays.asList(1, 2, 3, 4)));
		input.add(new ArrayList(Arrays.asList(2, 3, 4, 5)));

		System.out.println(maxSum.adjacent(input));
	}

	public int adjacent(ArrayList<ArrayList<Integer>> a) {

		int n = a.get(0).size();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return Math.max(a.get(0).get(0), a.get(1).get(0));
		}

		int dp[][] = new int[2][n];

		dp[0][0] = a.get(0).get(0);
		dp[0][1] = a.get(0).get(1);
		dp[1][0] = a.get(1).get(0);
		dp[1][1] = a.get(1).get(1);

		int tempMax;
		for (int i = 2; i < n; i++) {
			tempMax = dp[0][0];
			for (int j = 0; j < i - 1; j++) {
				tempMax = Math.max(tempMax, dp[0][j]);
				tempMax = Math.max(tempMax, dp[1][j]);
			}
			dp[0][i] = Math.max(a.get(0).get(i), a.get(0).get(i) + tempMax);
			dp[1][i] = Math.max(a.get(1).get(i), a.get(1).get(i) + tempMax);
		}
		int sol0 = Math.max(dp[0][n - 2], dp[0][n - 1]);
		int sol1 = Math.max(dp[1][n - 2], dp[1][n - 1]);
		return Math.max(sol0, sol1);
	}
}
