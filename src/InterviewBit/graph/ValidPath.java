package InterviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidPath {
	public static void main(String[] args) {
		ValidPath vaildPath = new ValidPath();
		System.out.println(
				vaildPath.solve(37, 38, 9, 2, new ArrayList<Integer>(Arrays.asList(15, 11, 7, 31, 3, 18, 18, 12, 31)),
						new ArrayList<Integer>(Arrays.asList(5, 5, 0, 29, 2, 14, 1, 30, 18))));

	}

	public String solve(int a, int b, int c, int r, ArrayList<Integer> x, ArrayList<Integer> y) {
		boolean v[][] = new boolean[a + 1][b + 1];
		// boolean sol = dfs(dp, 0, 0, d, e, f);
		if (!check(0, 0, r, x, y)) {
			return "NO";
		}
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		st.push(0);
		v[0][0] = true;
		int i, j;
		int it, jt;
		while (!st.isEmpty()) {
			j = st.pop();
			i = st.pop();
			// System.out.println(i + " " + j);
			if (i == a && j == b) {
				return "YES";
			}

			it = i - 1;
			jt = j - 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}
			it = i;
			jt = j - 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i + 1;
			jt = j - 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i - 1;
			jt = j;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i + 1;
			jt = j;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i - 1;
			jt = j + 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i;
			jt = j + 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

			it = i + 1;
			jt = j + 1;
			if (it >= 0 && it <= a && jt >= 0 && jt <= b && !v[it][jt] && check(it, jt, r, x, y)) {
				v[it][jt] = true;
				st.push(it);
				st.push(jt);
			}

		}

		return "NO";
	}

	private boolean dfs(boolean[][] dp, int i, int j, int r, ArrayList<Integer> x, ArrayList<Integer> y) {

		System.out.println(i + " " + j);
		if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
			return false;
		}
		if (dp[i][j]) {
			return false;
		}
		if (!check(i, j, r, x, y)) {
			return false;
		}
		dp[i][j] = true;
		if (i == dp.length - 1 && j == dp[0].length - 1) {
			return true;
		}
		System.out.println(" safe ");

		return dfs(dp, i - 1, j - 1, r, x, y) || dfs(dp, i, j - 1, r, x, y) || dfs(dp, i + 1, j - 1, r, x, y)
				|| dfs(dp, i - 1, j, r, x, y) || dfs(dp, i + 1, j, r, x, y) || dfs(dp, i - 1, j + 1, r, x, y)
				|| dfs(dp, i, j + 1, r, x, y) || dfs(dp, i + 1, j + 1, r, x, y);
	}

	private boolean check(int i, int j, int r, ArrayList<Integer> x, ArrayList<Integer> y) {
		for (int k = 0; k < x.size(); k++) {
			if (Math.sqrt(Math.pow(x.get(k) - i, 2) + Math.pow(y.get(k) - j, 2)) <= r) {
				return false;
			}
		}
		return true;
	}
}
