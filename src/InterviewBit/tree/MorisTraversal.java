package InterviewBit.tree;

import java.util.ArrayList;

public class MorisTraversal {
	public static void main(String[] args) {
		MorisTraversal traversal = new MorisTraversal();
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

		traversal.findIn(root);
		System.out.println("");
		System.out.println(traversal.inorderTraversal(root));
		System.out.println("");
		traversal.findIn(root);
	}

	public void findIn(TreeNode a) {
		if (a != null) {
			findIn(a.left);
			System.out.println(a.val);

			findIn(a.right);
		}
	}

	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		TreeNode current = a;
		TreeNode next = null;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		while (current != null) {
			if (current.left != null) {
				next = current.left;
				while (next.right != current && next.right != null) {

					next = next.right;

				}
				if (next.right == current) {
					next.right = null;
					System.out.println(current.val);
					sol.add(current.val);
					current = current.right;
				} else {
					next.right = current;

					current = current.left;
				}
			} else {
				System.out.println(current.val);
				sol.add(current.val);
				current = current.right;
			}
		}

		return sol;
	}
}
