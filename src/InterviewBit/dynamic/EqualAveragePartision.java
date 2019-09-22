package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EqualAveragePartision {
	public static void main(String[] args) {
		EqualAveragePartision e = new EqualAveragePartision();

		// System.out.println(e.avgset(new ArrayList<Integer>(Arrays.asList(47,
		// 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24))));
		System.out.println(e.avgset(new ArrayList<Integer>(Arrays.asList(19, 5, 38, 22, 44, 12, 17, 35))));

	}

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();

		int n = a.size();

		if (n < 2) {
			return sol;
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a.get(i);
		}

		Collections.sort(a);
		int[][] dp = new int[sum + 1][n];

		int x = -1;
		int y = -1;
		for (int i = 0; i <= sum && x == -1; i++) {
			for (int j = 0; j < n; j++) {
				if (i == a.get(j)) {
					dp[i][j] = 1;
					if (avgEqual(sum, n, i, i)) {
						x = i;
						y = j;
						break;
					}
				}
				if (j > 0 && i - a.get(j) > 0 && dp[i - a.get(j)][j - 1] != 0) {
					dp[i][j] = dp[i - a.get(j)][j - 1] + 1;
					if (avgEqual(sum, n, i, i)) {
						x = i;
						y = j;
						break;
					}

				}
				if (j > 0 && dp[i][j - 1] != 0) {
					dp[i][j] = dp[i][j - 1];
				}

			}
		}

		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		int iy = y;
		int counter = (x >= 0 && y >= 0) ? dp[x][y] : 0;
		while (counter > 0) {
			if (x == a.get(y)) {
				if (x == a.get(y) && counter == 1) {
					temp1.add(a.get(y));
					x = 0;
					y--;
					counter--;
				}
			} else if (dp[x][y - 1] == counter) {
				temp2.add(a.get(y));

				y--;

			} else if (dp[x - a.get(y)][y - 1] == counter - 1) {
				temp1.add(a.get(y));
				x = x - a.get(y);
				y--;
				counter--;
			}

		}
		for (int i = 0; i < n; i++) {
			if (i <= y || i > iy)
				temp2.add(a.get(i));
		}

		Collections.sort(temp1);
		Collections.sort(temp2);

		if (temp1.size() <= temp2.size()) {
			sol.add(temp1);
			sol.add(temp2);
		} else {
			sol.add(temp2);
			sol.add(temp1);
		}

		return sol;

	}

	private boolean avgEqual(int a, int n, int b, int m) {
		if (n == 0 || m == 0) {
			return false;
		}
		return ((1.0) * a / n) == ((1.0) * b / m);
	}

	public boolean splitArraySameAverage(int[] a) {
		int n = a.length;
		if (n == 0) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		int dp[][] = new int[sum + 1][n];
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				if (i == a[j]) {
					dp[i][j] = 1;
				} else if (i - a[j] > 0 && dp[i - a[j]][j - 1] == 1) {
					dp[i][j] = 1;
				} else if (j > 0 && dp[i][j - 1] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		return false;
	}
}
