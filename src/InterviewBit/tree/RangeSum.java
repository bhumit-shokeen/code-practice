package InterviewBit.tree;

//https://leetcode.com/problems/range-sum-query-mutable/submissions/

public class RangeSum {

	int[] num;
	int[] tree;

	public RangeSum(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return;
		}
		num = nums;
		int m = 1;
		while (n > Math.pow(2, m)) {
			m++;

		}
		m = (int) (2 * Math.pow(2, m)) - 1;
		tree = new int[m];
		makeTree(0, n - 1, 0);

		// for(int i =0 ;i< tree.length ; i++){
		// System.out.print(" "+tree[i]);
		// }
	}

	private void makeTree(int s, int e, int root) {
		if (s == e) {
			tree[root] = num[s];
			return;
		}
		int mid = (s + e) / 2;
		makeTree(s, mid, (2 * root) + 1);
		makeTree(mid + 1, e, (2 * root) + 2);

		tree[root] = tree[(2 * root) + 1] + tree[(2 * root) + 2];

	}

	public void update(int i, int val) {
		if (num.length == 0) {
			return;
		}
		update(0, num.length - 1, i, val, 0);
	}

	private void update(int s, int e, int index, int val, int root) {
		if (e < s) {
			return;
		}
		int mid = (s + e) / 2;
		if (s == e && s == index) {
			num[index] = val;
			tree[root] = val;
			return;
		} else if (s <= index && e >= index) {
			update(s, mid, index, val, (2 * root) + 1);
			update(mid + 1, e, index, val, (2 * root) + 2);
			tree[root] = tree[(2 * root) + 1] + tree[(2 * root) + 2];

		}

	}

	public void update1(int i, int val) {
		if (num.length == 0) {
			return;
		}
		for (int j = tree.length - 1; j >= 0; j--) {
			if (tree[j] == num[i]) {

				int diff = val - num[i];
				num[i] = val;
				tree[j] = val;
				int parent = (j - 1);
				while (parent >= 0) {
					parent /= 2;
					tree[parent] += diff;

					parent = (parent - 1);
					// System.out.println("p " +parent);

				}
				break;
			}
		}

	}

	public int sumRange(int i, int j) {
		if (num.length == 0) {
			return 0;
		}
		return findSum(0, num.length - 1, 0, i, j);

	}

	private int findSum(int s, int e, int root, int qS, int qE) {
		if (Math.min(e, qE) - Math.max(qS, s) < 0) {
			return 0;
		} else if (qS <= s && qE >= e) {
			return tree[root];
		} else {
			int mid = (s + e) / 2;
			return findSum(s, mid, (2 * root) + 1, qS, qE) + findSum(mid + 1, e, (2 * root) + 2, qS, qE);
		}
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 * 
 * ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
 * [[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
 */