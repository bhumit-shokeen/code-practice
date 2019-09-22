package InterviewBit.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Iterator {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		Iterator i = new Iterator(root);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	Deque<TreeNode> stack = new LinkedList<TreeNode>();

	public Iterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();

	}

	/** @return the next smallest number */
	public int next() {
		TreeNode p = stack.poll();
		TreeNode temp = p.right;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}

		return p.val;

	}
}
