package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverTree {
	public static void main(String[] args) {
		RecoverTree recoverTree = new RecoverTree();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(18);
		root.right.right = new TreeNode(14);
		// recoverTree.recoverTree(root);
		for (Integer i : recoverTree.recoverTree(root))
			System.out.println(i);

	}

	public ArrayList<Integer> recoverTree(TreeNode a) {

		TreeNode one = null;
		TreeNode two = null;
		TreeNode three = null;
		TreeNode pre = a;
		while (pre.left != null) {
			pre = pre.left;
		}
		TreeNode current = a;
		TreeNode predecessor = null;
		while (current != null) {
			if (current.left == null) {
				if (pre.val > current.val) {
					if (one == null) {
						one = pre;
						three = current;
					} else {
						two = current;
					}
				}
				System.out.println(current.val);
				pre = current;
				current = current.right;

			} else {
				predecessor = pre(current);
				if (predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				} else {
					if (pre.val > current.val) {
						if (one == null) {
							one = pre;
							three = current;
						} else {
							two = current;
						}
					}
					System.out.println(current.val);
					predecessor.right = null;
					pre = current;
					current = current.right;
				}
			}
		}

		return new ArrayList<Integer>(Arrays.asList(two != null ? two.val : three.val, one.val));
	}

	private TreeNode pre(TreeNode current) {
		TreeNode a = current.left;
		while (a.right != null && a.right != current) {
			a = a.right;
		}
		return a;
	}

}
