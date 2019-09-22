package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

class Pair {
	int val;
	TreeNode node;

	Pair(int a, TreeNode n) {
		val = a;
		node = n;
	}
}

public class VerticalTraversal {
	public static void main(String[] args) {
		VerticalTraversal verticalTraversal = new VerticalTraversal();
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(4);
		verticalTraversal.inorderTraversal(root);
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode a) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<Pair> q = new LinkedList<Pair>();

		q.add(new Pair(0, a));

		Pair temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			ArrayList<Integer> mapEle = map.get(temp.val);

			if (mapEle == null) {
				map.put(temp.val, new ArrayList<Integer>(Arrays.asList(temp.node.val)));
			} else {
				mapEle.add(temp.node.val);
			}

			if (temp.node.left != null) {
				q.add(new Pair(temp.val - 1, temp.node.left));
			}
			if (temp.node.right != null) {
				q.add(new Pair(temp.val + 1, temp.node.right));
			}

		}
		ArrayList<Integer> ary = new ArrayList<Integer>(map.keySet());
		Collections.sort(ary);
		for (Integer i : ary) {
			sol.add(map.get(i));
		}
		return sol;
	}

	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		findIn(a, sol);
		return sol;
	}

	private void findIn(TreeNode a, ArrayList<Integer> sol) {
		if (a != null) {
			findIn(a.left, sol);
			sol.add(a.val);
			findIn(a.right, sol);
		}
	}
}
