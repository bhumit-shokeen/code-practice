package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class CartesianTree {
	public static void main(String[] args) {
		CartesianTree cartesianTree = new CartesianTree();
		TreeNode sol = cartesianTree.buildTree(new ArrayList(Arrays.asList(3, 1, 2)));
	}

	public TreeNode buildTree(ArrayList<Integer> a) {
		TreeNode root = null;
		TreeNode temp = null;
		TreeNode tempPre = null;
		if (a.size() > 0) {
			root = new TreeNode(a.get(0));
		}

		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) > root.val) {
				temp = root;
				root = new TreeNode(a.get(i));
				root.left = temp;
			} else {
				temp = root;
				while (temp != null && a.get(i) < temp.val) {
					tempPre = temp;
					temp = temp.right;
				}
				if (temp == null) {
					tempPre.right = new TreeNode(a.get(i));
				} else {

					tempPre.right = new TreeNode(a.get(i));
					tempPre.right.left = temp;
				}
			}
		}
		return root;
	}
}
