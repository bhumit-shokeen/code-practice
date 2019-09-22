package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class KnapsackBday {
	public static void main(String[] args) {
		KnapsackBday knapsackBday = new KnapsackBday();
		System.out.println(knapsackBday.solve(Arrays.asList(4, 6), Arrays.asList(1, 3), Arrays.asList(5, 3)));
	}

	int dp[];

	public int solve(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			max = Math.max(max, a.get(i));
		}

		makeDP(max, b, c);
		int sol = 0;
		for (int i = 0; i < a.size(); i++) {
			sol += dp[a.get(i)];
		}
		return sol;
	}

	private void makeDP(int max, List<Integer> b, List<Integer> c) {
		dp = new int[max + 1];
		int tempSum;
		for (int i = 1; i < dp.length; i++) {
			tempSum = Integer.MAX_VALUE;
			for (int j = 0; j < b.size(); j++) {
				if (i - b.get(j) >= 0) {
					tempSum = Math.min(tempSum, dp[i - b.get(j)] + c.get(j));
				}
			}
			dp[i] = tempSum;
		}

	}

	private int sol(List<Integer> a, List<Integer> b, List<Integer> c) {
		int i;
		for (i = 0; i < a.size(); i++) {
			if (a.get(i) > 0) {
				break;
			}
		}
		if (i == a.size()) {
			return 0;
		}
		int left;
		int sol = Integer.MAX_VALUE;
		for (int j = 0; j < b.size(); j++) {
			left = a.get(i) - b.get(j);
			if (left >= 0) {

				a.set(i, a.get(i) - b.get(j));
				sol = Math.min(sol, c.get(j) + sol(a, b, c));
				a.set(i, a.get(i) + b.get(j));
			}
		}
		return sol;
	}
}
