package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class LIS {
	public static void main(String[] args) {
		LIS lis = new LIS();
		System.out.println(lis.lis(
				Arrays.asList(14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78)));

	}

	public int lis(final List<Integer> a) {
		int n = a.size();
		int[] dp = new int[n];
		int temp;
		int sol = 0;
		for (int i = 0; i < dp.length; i++) {
			temp = 0;
			for (int j = 0; j < i; j++) {
				if (a.get(j) < a.get(i)) {
					temp = Math.max(temp, dp[j]);
				}
			}
			dp[i] = temp + 1;
			sol = Math.max(sol, dp[i]);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(a.get(i) + " : " + dp[i]);
		}
		return sol;
	}
}
