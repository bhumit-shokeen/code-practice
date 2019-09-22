package InterviewBit.tree;

import java.util.ArrayList;

public class SegmentTree {
	public static void main(String[] args) {
		SegmentTree s = new SegmentTree();
		// min range query
		// System.out.println(s.findMin(new ArrayList(Arrays.asList(-1, 2, -4,
		// 6, 1, 1, 8))));
	}

	public int findMin(ArrayList<Integer> a) {
		int n = a.size();
		int m = 1;
		while (n > Math.pow(2, m)) {
			m++;
		}
		m = (int) (2 * (Math.pow(2, m))) - 1;
		int[] tree = new int[m];

		makeTree(a, 0, n - 1, tree, 0);

		return rangeQuery(a, 0, n - 1, tree, 0, 3, 6);
	}

	private int rangeQuery(ArrayList<Integer> a, int s, int e, int[] tree, int root, int qS, int qE) {

		// base case later

		if (Math.min(qE, e) - Math.max(qS, s) < 0) {
			return Integer.MAX_VALUE;
		} else if (qS <= s && qE >= e) {
			return tree[root];
		} else {
			int mid = (s + e) / 2;
			return Math.min(rangeQuery(a, s, mid, tree, (2 * root) + 1, qS, qE),
					rangeQuery(a, mid + 1, e, tree, (2 * root) + 2, qS, qE));
		}

	}

	private void makeTree(ArrayList<Integer> a, int s, int e, int[] tree, int root) {

		if (s == e) {
			tree[root] = a.get(s);
			return;
		}
		int mid = (s + e) / 2;
		makeTree(a, s, mid, tree, (2 * root) + 1);
		makeTree(a, mid + 1, e, tree, (2 * root) + 2);
		tree[root] = Math.min(tree[(2 * root) + 1], tree[(2 * root) + 2]);

	}

}
