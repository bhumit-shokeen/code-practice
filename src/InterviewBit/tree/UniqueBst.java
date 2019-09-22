package InterviewBit.tree;

import java.util.ArrayList;

public class UniqueBst {
	public static void main(String[] args) {
		UniqueBst tree = new UniqueBst();
		for (TreeNode root : tree.generateTrees(3)) {
			System.out.println("");
			postOrder(root);
		}

	}

	private static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(" " + root.val);
		}

	}

	public ArrayList<TreeNode> generateTrees(int a) {
		return getTreeList(1, a);

	}

	public ArrayList<TreeNode> getTreeList(int s, int e) {
		if (s > e) {
			return null;
		}

		ArrayList<TreeNode> sol = new ArrayList<TreeNode>();
		if (s == e) {
			sol.add(new TreeNode(s));
			return sol;
		}

		for (int i = s; i <= e; i++) {
			ArrayList<TreeNode> leftList = getTreeList(s, i - 1);
			ArrayList<TreeNode> rightList = getTreeList(i + 1, e);
			if (leftList != null && rightList != null) {
				for (TreeNode left : leftList) {
					for (TreeNode right : rightList) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						sol.add(root);

					}
				}
			} else if (leftList != null) {
				for (TreeNode left : leftList) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					sol.add(root);

				}
			} else if (rightList != null) {
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(i);
					root.right = right;
					sol.add(root);

				}
			}
		}
		return sol;
	}

}
