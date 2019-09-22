package InterviewBit.tree;

public class Identical {

	public static void main(String[] args) {
		Identical identical = new Identical();
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(4);
		System.out.println(identical.isSameTree(root, root.right));
	}

	public int isSameTree(TreeNode a, TreeNode b) {

		if (a == null && b == null) {
			return 1;
		}

		if (a != null && b != null) {
			if ((a.val == b.val) && (isSameTree(a.left, b.left) == 1) && (isSameTree(a.right, b.right) == 1)) {
				return 1;
			}
		}
		return 0;
	}

	public int isSymmetric(TreeNode a) {
		if (a == null) {
			return 1;
		}
		if (isSameTree(a.left, a.right) == 1) {
			return 1;
		}
		return 0;
	}

}
