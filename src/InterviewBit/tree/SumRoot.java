package InterviewBit.tree;

import java.util.ArrayList;

public class SumRoot {
	public static void main(String[] args) {
		SumRoot sumRoot = new SumRoot();
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(14);
		root.right.right = new TreeNode(18);
		// System.out.println(sumRoot.sumNumbers(root));
		sumRoot.pathSum(root, 21);
	}

	public int sumNumbers(TreeNode a) {
		return (int) ((sol(a, 0) % 1003));

	}

	private int sol(TreeNode a, int sum) {
		if (a == null) {
			return sum;
		}
		int newSum = ((sum * 10) + a.val) % 1003;
		if (a.left == null) {
			return sol(a.right, newSum);

		} else if (a.right == null) {
			return sol(a.left, newSum);

		}
		return (sol(a.left, newSum) + sol(a.right, newSum)) % 1003;

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode a, int b) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		findSol(a, b, temp, sol);
		return sol;
	}

	private void findSol(TreeNode a, int b, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> sol) {
		if (a == null) {
			return;
		}
		if (a.left == null && a.right == null) {
			temp.add(a.val);
			int sum = 0;
			for (Integer i : temp) {
				sum = sum + i;
			}
			if (sum == b) {
				sol.add(new ArrayList<Integer>(temp));
			}
			temp.remove(temp.size() - 1);
			return;
		}
		temp.add(a.val);
		findSol(a.left, b, temp, sol);
		findSol(a.right, b, temp, sol);
		temp.remove(temp.size() - 1);

	}
}
