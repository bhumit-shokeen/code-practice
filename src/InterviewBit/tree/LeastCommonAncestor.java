package InterviewBit.tree;

public class LeastCommonAncestor {
	public static void main(String[] args) {
		LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		System.out.println(leastCommonAncestor.lca(root, 10, 14));

	}

	boolean flag1 = false;
	boolean flag2 = false;

	public int lca(TreeNode a, int b, int c) {
		TreeNode sol = find(a, b, c);
		if (sol != null && flag1 && flag2)
			return sol.val;
		else
			return -1;
	}

	private TreeNode find(TreeNode a, int b, int c) {
		if (a == null) {
			return null;
		}
		TreeNode temp = null;
		if (a.val == b) {
			flag1 = true;
			temp = a;
		}
		if (a.val == c) {
			flag2 = true;
			temp = a;
		}
		TreeNode left = find(a.left, b, c);
		TreeNode right = find(a.right, b, c);
		if (temp != null) {
			return temp;
		}

		if (left != null && right != null) {
			return a;
		}
		if (left != null) {
			return left;
		} else
			return right;
	}
}
