package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;

class TreeCustomNode {
	int val;
	int size;
	int rs;
	TreeCustomNode left, right;

	public TreeCustomNode(int x) {
		val = x;
		size = 0;
		rs = 1;
	}

}

public class Inversions {
	public static void main(String[] args) {
		Inversions inversions = new Inversions();
		System.out.println(inversions.countInversions(new ArrayList<Integer>(Arrays.asList(2, 4, 1, 3, 5))));
	}

	int sol = 0;

	public int countInversions(ArrayList<Integer> a) {
		TreeCustomNode root = null;

		for (Integer i : a) {
			root = insert(root, i, 0);
		}

		return sol;
	}

	private TreeCustomNode insert(TreeCustomNode root, int val, int addSol) {
		if (root == null) {
			sol = sol + addSol;
			return new TreeCustomNode(val);
		}
		if (val < root.val) {
			root.left = insert(root.left, val, addSol + root.rs);
		} else {
			root.right = insert(root.right, val, addSol);
			root.rs = root.rs + 1;
		}

		return root;

	}

}
