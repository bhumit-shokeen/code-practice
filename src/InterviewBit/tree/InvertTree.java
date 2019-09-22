package InterviewBit.tree;

public class InvertTree {
	public static void main(String[] args) {
		InvertTree invertTree = new InvertTree();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		invertTree.disp(root);
		invertTree.invertTree(root);
		System.out.println("");
		invertTree.disp(root);
	}

	public TreeNode invertTree(TreeNode a) {
		if (a != null) {
			TreeNode temp = a.right;
			a.right = invertTree(a.left);
			a.left = invertTree(temp);

		}
		return a;
	}

	public void disp(TreeNode a) {
		if (a != null) {
			disp(a.left);
			System.out.println(a.val);
			disp(a.right);

		}

	}
}
