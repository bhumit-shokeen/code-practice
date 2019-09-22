package InterviewBit.tree;

import java.util.Deque;
import java.util.LinkedList;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		System.out.println(twoSum.t2Sum(root, 20));
	}

	public int t2Sum(TreeNode a, int b) {
		Deque<TreeNode> s1 = new LinkedList<TreeNode>();
		Deque<TreeNode> s2 = new LinkedList<TreeNode>();

		TreeNode root = a;
		while (root != null) {
			s1.push(root);
			root = root.left;
		}
		TreeNode p1 = s1.peek();
		root = a;
		while (root != null) {
			s2.push(root);
			root = root.right;
		}
		TreeNode p2 = s2.peek();
		while (p1 != null && p2 != null && p1 != p2) {
			if (p1.val + p2.val == b) {
				return 1;
			} else if (p1.val + p2.val < b) {
				p1 = s1.poll();
				TreeNode temp = p1 == null ? null : p1.right;
				while (temp != null) {
					s1.push(temp);
					temp = temp.left;
				}
				p1 = s1.peek();

			} else {
				p2 = s2.poll();
				TreeNode temp = p2 == null ? null : p2.left;
				while (temp != null) {
					s2.push(temp);
					temp = temp.right;
				}
				p2 = s2.peek();

			}
		}
		return 0;
	}
}
