package InterviewBit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	char v;
	Node left;
	Node right;

	public Node(char v) {
		this.v = v;
		left = null;
		right = null;
	}
}

/* Name of the class has to be "Main" only if the class is public. */
public class SerializeTree {

	public static void main(String[] args) throws java.lang.Exception {
		SerializeTree i = new SerializeTree();
		Node root = new Node('1');
		root.left = new Node('2');
		root.left.right = new Node('4');
		root.right = new Node('3');

		ArrayList<Character> sol = i.serializeTree(root);
		System.out.println(sol);

		i.disp(i.makeTree(sol, 0));

		i.disp(root);
	}

	private Node makeTree(ArrayList<Character> c, int i) {
		if (i >= c.size() || c.get(i) == '*') {
			return null;
		}
		Node root = new Node(c.get(i));
		root.left = makeTree(c, (2 * i) + 1);
		root.right = makeTree(c, (2 * i) + 2);
		return root;
	}

	private ArrayList<Character> serializeTree(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Character> sol = new ArrayList<Character>();

		q.add(root);

		Node pop = null;
		while (!q.isEmpty()) {
			pop = q.remove();
			sol.add(pop.v);
			if (pop.v == '*') {
				continue;
			}
			if (pop.left != null) {
				q.add(pop.left);
			} else {
				q.add(new Node('*'));
			}

			if (pop.right != null) {
				q.add(pop.right);
			} else {
				q.add(new Node('*'));
			}

		}

		return sol;

	}

	private void disp(Node root) {
		if (root != null) {
			System.out.println(root.v);
			disp(root.left);
			disp(root.right);
		}
	}
}
