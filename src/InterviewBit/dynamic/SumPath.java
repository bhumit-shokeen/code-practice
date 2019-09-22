package InterviewBit.dynamic;

import java.util.HashMap;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class SumPath {
	public static void main(String[] args) {
		SumPath sumPath = new SumPath();
		TreeNode root;
		root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		System.out.println(sumPath.maxPathSum(root));
	}

	public int maxPathSum(TreeNode a) {
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		int sol = Integer.MIN_VALUE;
		TreeNode pop = null;
		TreeNode peek = null;
		if (a != null) {
			s.push(a);
		}
		while (!s.isEmpty()) {
			peek = s.peek();
			if ((peek.left != null) && (peek.left != pop && (peek.right == null || peek.right != pop))) {
				s.push(peek.left);
			} else if (peek.right != null && peek.right != pop) {
				s.push(peek.right);
			} else {
				pop = s.pop();
				if (pop.left == null && pop.right == null) {
					sol = Math.max(sol, pop.val);
					map.put(pop, pop.val);
				} else if (pop.left == null) {
					int temp = Math.max(pop.val, pop.val + map.get(pop.right));
					sol = Math.max(sol, temp);
					map.put(pop, temp);
				} else if (pop.right == null) {
					int temp = Math.max(pop.val, pop.val + map.get(pop.left));
					sol = Math.max(sol, temp);
					map.put(pop, temp);
				} else {
					int l = map.get(pop.left);
					int r = map.get(pop.right);
					int temp = Math.max(pop.val, pop.val + l);
					temp = Math.max(temp, pop.val + r);

					map.put(pop, temp);

					temp = Math.max(temp, pop.val + r + l);
					sol = Math.max(sol, temp);

				}
				System.out.println(pop.val);
			}
		}
		return sol;
	}

}
