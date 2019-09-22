package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {

	public static void main(String[] args) {
		MaxRectangle maxRectangle = new MaxRectangle();

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList(Arrays.asList(0, 1, 0)));
		input.add(new ArrayList(Arrays.asList(0, 1, 1)));
		input.add(new ArrayList(Arrays.asList(0, 1, 1)));

		System.out.println(maxRectangle.maximalRectangle(input));
	}

	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {

		int[] dp = new int[a.get(0).size()];
		int max = 0;
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < dp.length; j++) {
				if (a.get(i).get(j) == 0) {
					dp[j] = 0;
				} else {
					dp[j] = dp[j] + 1;
				}
			}
			max = Math.max(max, finfMax(dp));

		}

		return max;
	}

	private int finfMax(int[] dp) {
		int n = dp.length;
		int i = 0;
		int sol = 0;
		Stack<Integer> s = new Stack<Integer>();
		while (i < n) {
			if (s.isEmpty() || dp[s.peek()] < dp[i]) {
				s.push(i);
				i++;
			} else {
				int top = s.pop();
				sol = Math.max(sol, (dp[top] * (s.isEmpty() ? i : i - 1 - s.peek())));
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			sol = Math.max(sol, (dp[top] * (s.isEmpty() ? i : i - 1 - s.peek())));

		}

		return sol;
	}

}
