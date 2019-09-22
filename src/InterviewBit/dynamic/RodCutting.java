package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class RodCutting {
	public static void main(String[] args) {
		RodCutting rodCutting = new RodCutting();
		System.out.println(rodCutting.rodCut(6, new ArrayList<Integer>(Arrays.asList(1, 2, 5))));
	}

	class Node {
		long cost;
		int index;

		public Node(long cost, int index) {
			this.cost = cost;
			this.index = index;
		}
	}

	static Node[][] dp;

	public ArrayList<Integer> rodCut(int a, ArrayList<Integer> b) {
		b.add(0, 0);
		b.add(a);
		dp = new Node[b.size()][b.size()];

		// sol(b, 0, b.size() - 1);
		soli(b, 0, b.size() - 1);

		ArrayList<Integer> sol = new ArrayList<Integer>();
		findSol(0, b.size() - 1, sol, b);

		// Collections.reverse(sol);
		return sol;

	}

	private void findSol(int s, int e, ArrayList<Integer> sol, ArrayList<Integer> b) {
		if (dp[s][e] != null && dp[s][e].index != -1) {
			sol.add(b.get(dp[s][e].index));
			findSol(s, dp[s][e].index, sol, b);
			findSol(dp[s][e].index, e, sol, b);
		}
	}

	private int soli(ArrayList<Integer> b, int s, int e) {
		int n = b.size();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (i == j || i == j - 1) {
					dp[i][j] = new Node(0, -1);
				} else {
					long cost = Long.MAX_VALUE;
					int im = 0;
					long tempCost;
					for (int k = i + 1; k < j; k++) {
						tempCost = b.get(j) - b.get(i) + dp[i][k].cost + dp[k][j].cost;
						if (tempCost < cost) {
							cost = tempCost;
							im = k;
						}
					}
					dp[i][j] = new Node(cost + b.get(j) - b.get(i), im);
				}

			}

		}

		return 0;

	}

	private long sol(ArrayList<Integer> b, int s, int e) {
		if (e == s + 1) {
			return 0;

		}
		if (dp[s][e] != null) {
			return dp[s][e].cost;
		}

		int im = 0;
		long costM = Long.MAX_VALUE;
		long cost;
		for (int i = s + 1; i < e; i++) {
			cost = b.get(e) - b.get(s) + sol(b, s, i) + sol(b, i, e);
			if (cost < costM) {
				costM = cost;
				im = i;
			}
		}
		dp[s][e] = new Node(costM, im);
		return costM;

	}
}
