package InterviewBit.tree;

public class Balance {
	public static void main(String[] args) {
		Balance balance = new Balance();
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(4);
		System.out.println(balance.isBalanced(root));
	}

	int sol = 1;

	public int isBalanced(TreeNode a) {
		blc(a);
		return sol;
	}

	private int blc(TreeNode a) {
		if (sol == 0) {
			return 10;
		}
		if (a == null) {
			return 0;
		} else {
			int leftH = blc(a.left);
			int rightH = blc(a.right);
			int bal = leftH - rightH;
			if (bal > 1 || bal < -1) {
				sol = 0;
				return 10;
			}
			return Integer.max(leftH, rightH) + 1;
		}

	}
}
