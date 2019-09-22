package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxCoin {
	public static void main(String[] args) {
		MaxCoin maxCoin = new MaxCoin();
		System.out.println(maxCoin.maxcoin(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
	}

	public int maxcoin(ArrayList<Integer> a) {
		int n = a.size();
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = a.get(i);
			if (i != n - 1) {
				dp[i][i + 1] = a.get(i) > a.get(i + 1) ? a.get(i) : a.get(i + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 2 && 2 + i + j < n; j++) {
				dp[j][2 + i + j] = Math.max(a.get(j) + Math.min(dp[j + 2][2 + i + j], dp[j + 1][2 + i + j - 1]),
						a.get(2 + i + j) + Math.min(dp[j][2 + i + j - 2], dp[j + 1][2 + i + j - 1]));
			}
		}

		return dp[0][n - 1];
	}

	public int maxcoin1(ArrayList<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum = sum + a.get(i);
		}
		return sol(a, 0, a.size() - 1, 1, sum);
	}

	private int sol(ArrayList<Integer> a, int s, int e, int turn, int sum) {
		if (turn == 1) {
			if (e - s == 1) {
				return a.get(s) > a.get(e) ? a.get(s) : a.get(e);
			}
			int s1 = a.get(s) + sol(a, s + 1, e, 0, sum - a.get(s));
			int s2 = a.get(e) + sol(a, s, e - 1, 0, sum - a.get(e));
			return s1 > s2 ? s1 : s2;
		} else {
			if (e - s == 1) {
				return a.get(s) < a.get(e) ? a.get(s) : a.get(e);
			}
			int s1 = a.get(s) + sum - a.get(s) - sol(a, s + 1, e, 1, sum - a.get(s));
			int s2 = a.get(e) + sum - a.get(e) - sol(a, s, e - 1, 1, sum - a.get(e));
			return s1 > s2 ? sum - s1 : sum - s2;

		}
	}
}
