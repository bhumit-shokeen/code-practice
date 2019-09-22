package InterviewBit.array.binary_serach;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {
	public static void main(String[] args) {
		PaintersPartitionProblem paintersPartitionProblem = new PaintersPartitionProblem();
		System.out.println(paintersPartitionProblem.paint(2, 10,
				new ArrayList<Integer>(Arrays.asList(640, 435, 647, 352, 8, 90, 960, 329, 859))));
		System.out.println(
				paintersPartitionProblem.paintBinary(12, 1, new ArrayList<Integer>(Arrays.asList(31, 14, 19, 75))));

		System.out.println(
				paintersPartitionProblem.paintDp(1, 1000000, new ArrayList<Integer>(Arrays.asList(1000000, 1000000))));
		System.out.println(paintersPartitionProblem.paintBinary(1, 1000000,
				new ArrayList<Integer>(Arrays.asList(1000000, 1000000))));

	}

	public int paintBinary(int a, int b, ArrayList<Integer> c) {
		int upper = 0;
		int lower = -1;
		int mid;
		int k;
		for (int i = 0; i < c.size(); i++) {
			upper += c.get(i);
			if (lower < c.get(i)) {
				lower = c.get(i);
			}
		}

		while (upper > lower) {
			mid = (upper + lower) / 2;
			k = getMen(c, mid);
			if (k <= a) {
				upper = mid;
			} else {
				lower = mid + 1;
			}
		}

		return (int) ((lower % 10000003L) * (b % 10000003L) % 10000003L);

	}

	private int getMen(ArrayList<Integer> c, int mid) {
		int sum = 0;
		int men = 1;
		for (int i = 0; i < c.size(); i++) {
			sum += c.get(i);
			if (sum > mid) {
				men++;
				sum = c.get(i);
			}
		}
		return men;
	}

	public int paintDp(int a, int b, ArrayList<Integer> c) {
		if (c.size() == 1) {
			return (c.get(0) * b) % 10000003;
		}
		if (a > c.size()) {
			a = c.size();
		}
		int sum = 0;
		int min;
		int temp;
		int dp[][] = new int[a + 1][c.size() + 1];
		for (int i = dp[0].length - 2; i >= 0; i--) {
			sum += c.get(i);
			dp[1][i] = sum;
		}
		sum = 0;
		for (int i = 0; i < dp[0].length - 1; i++) {
			sum += c.get(i);
			dp[0][i] = sum;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][dp[0].length - 1] = 0;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length - 1; j++) {
				min = Integer.MAX_VALUE;

				for (int k = j; k < dp[i].length - 2; k++) {
					temp = Integer.max(dp[0][k] - dp[0][j] + c.get(j), dp[i - 1][k + 1]);
					if (temp < min) {
						min = temp;
					}
				}
				dp[i][j] = min;
			}
		}

		return (int) ((1L * dp[a][0] * b) % 10000003);
	}

	public int paint(int a, int b, ArrayList<Integer> c) {

		return (int) (getCost(a, b, c, 0) % 10000003);
	}

	private long getCost(int a, int b, ArrayList<Integer> c, int i) {
		if (i >= c.size()) {
			System.out.println("a:" + a + " c: end" + " i:" + i + " ret:" + 0);
			return 0;
		}
		long ret = Long.MAX_VALUE;
		long min;
		long temp;
		long sum = 0;
		if (a > 0) {
			min = Long.max(c.get(i) * b, getCost(a - 1, b, c, i + 1));
			sum = c.get(i);
			for (int j = i + 1; j < c.size(); j++) {
				sum += c.get(j);
				temp = Long.max(sum * b, getCost(a - 1, b, c, j + 1));
				if (temp < min) {
					min = temp;
				}

			}

			ret = min;
		}
		System.out.println("a:" + a + " c:" + c.get(i) + " i:" + i + " ret:" + ret);
		return ret;
	}

}
