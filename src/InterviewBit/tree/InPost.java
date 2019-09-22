package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class InPost {

	public static void main(String[] args) {
		InPost inPost = new InPost();
		TreeNode root = inPost.buildTree(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)),
				new ArrayList<Integer>(Arrays.asList(3, 2, 4, 1, 5)));
	}

	public TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
		return makeTree(in, post, 0, in.size() - 1, 0, in.size() - 1);
	}

	private TreeNode makeTree1(ArrayList<Integer> in, ArrayList<Integer> post, int s, int e, int ps, int pe) {
		if (e < s) {
			return null;
		}
		if (s == e) {
			return new TreeNode(in.get(s));
		}
		int index = -1;
		for (int i = s; i <= e; i++) {
			if (in.get(i).equals(post.get(pe))) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println(s + " : " + e + " : " + ps + " : " + pe);
		}

		TreeNode root = new TreeNode(in.get(index));
		root.left = makeTree1(in, post, s, index - 1, ps, ps + (index - 1 - s));
		root.right = makeTree1(in, post, index + 1, e, ps + (index - s), pe - 1);
		return root;

	}

	private TreeNode makeTree(ArrayList<Integer> a, ArrayList<Integer> b, int s, int e, int ps, int pe) {
		if (s > e) {
			return null;
		}
		if (s == e) {
			return new TreeNode(a.get(s));
		}
		int index = -1;
		for (int i = s; i <= e; i++) {
			if (a.get(i).equals(b.get(ps))) {
				index = i;
				break;
			}
		}
		TreeNode root = new TreeNode(a.get(index));
		root.left = makeTree(a, b, s, index - 1, ps + 1, ps + (index - s));
		root.right = makeTree(a, b, index + 1, e, ps + (index - s) + 1, pe);
		return root;
	}
}
