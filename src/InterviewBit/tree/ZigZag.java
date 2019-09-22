package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZag {
	public static void main(String[] args) {
		ZigZag zigZag = new ZigZag();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		for (ArrayList<Integer> i : zigZag.zigzagLevelOrder(root)) {
			System.out.println(i);
		}
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();

		s1.push(a);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				TreeNode tmp = null;
				while (!s1.isEmpty()) {
					tmp = s1.pop();
					temp.add(tmp.val);
					if (tmp.left != null) {
						s2.push(tmp.left);
					}
					if (tmp.right != null) {
						s2.push(tmp.right);
					}

				}
				sol.add(temp);
			}

			if (!s2.isEmpty()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				TreeNode tmp = null;
				while (!s2.isEmpty()) {
					tmp = s2.pop();
					temp.add(tmp.val);
					if (tmp.right != null) {
						s1.push(tmp.right);
					}
					if (tmp.left != null) {
						s1.push(tmp.left);
					}

				}
				sol.add(temp);

			}
		}
		return sol;
	}
}
