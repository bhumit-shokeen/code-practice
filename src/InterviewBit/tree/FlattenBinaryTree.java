package InterviewBit.tree;

import java.util.Stack;

public class FlattenBinaryTree {
	public static void main(String[] args) {
		FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		TreeNode temp = flattenBinaryTree.flatten(root);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.right;
		}

	}

	public TreeNode flatten(TreeNode a) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(a);
		TreeNode node = null;
		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			node.left = null;
			node.right = stack.isEmpty() ? null : stack.peek();
		}
		return a;
	}

	public TreeNode flatten1(TreeNode a) {
		if (a == null || (a.left == null && a.right == null)) {
			return a;
		}

		if (a.left != null) {
			flatten(a.left);
			TreeNode tempLeft = a.left;
			while (tempLeft.right != null) {
				tempLeft = tempLeft.right;
			}
			tempLeft.right = a.right;
			a.right = a.left;
			a.left = null;
		}
		flatten(a.right);
		return a;
	}
}
