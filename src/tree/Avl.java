package tree;

class Node {
	int value;
	int height;
	Node left;
	Node right;

	Node(int x) {
		value = x;
		height = 1;
		left = null;
		right = null;
	}
}

public class Avl {
	public static void main(String[] args) {
		Avl tree = new Avl();
		Node root = null;
		root = tree.insert(root, 8);
		root = tree.insert(root, 5);
		root = tree.insert(root, 4);
		root = tree.insert(root, 1);

		tree.displayInOrder(root);

		// root = tree.delete(root, 8);
		// tree.display(root);

	}

	private Node delete(Node root, int x) {
		if (x < root.value) {
			root.left = delete(root.left, x);
		} else if (x > root.value) {
			root.right = delete(root.right, x);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left != null && root.right != null) {
				int pre = findPre(root.left);
				root.value = pre;
				root.left = delete(root.left, pre);

			} else if (root.right != null) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return root;
	}

	private int findPre(Node root) {
		if (root.left == null && root.right == null) {
			return root.value;
		} else {
			return findPre(root.right);
		}
	}

	private Node insert(Node root, int x) {
		if (root == null) {
			return new Node(x);
		}
		if (x < root.value) {
			root.left = insert(root.left, x);
		} else {
			root.right = insert(root.right, x);
		}
		int balance = getBalance(root);
		// rr
		if (balance > 1 && x < root.left.value) {
			root = rightRotate(root);
		}
		// ll
		else if (balance < -1 && x > root.right.value) {
			root = leftRotate(root);
		}
		// rl
		else if (balance < -1 && x < root.right.value) {
			root.left = rightRotate(root.left);
			root = leftRotate(root);
		}
		// lr
		else if (balance > 1 && x > root.left.value) {
			root.right = leftRotate(root.right);
			root = rightRotate(root);
		}
		root.height = Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

		return root;
	}

	private Node rightRotate(Node root) {
		Node x = root.left;
		Node y = root.left.right;

		x.right = root;
		root.left = y;
		root = x;

		root.right.height = Integer.max(getHeight(root.right.left), getHeight(root.right.right)) + 1;
		root.height = Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

		return root;
	}

	private Node leftRotate(Node root) {
		Node x = root.right;
		Node y = root.right.left;

		x.left = root;
		root.right = y;
		root = x;

		root.left.height = Integer.max(getHeight(root.left.left), getHeight(root.left.right)) + 1;
		root.height = Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

		return root;
	}

	private void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.println(root.value);
			display(root.right);
		}

	}

	private void displayInOrder(Node root) {
		if (root != null) {
			System.out.println(root.value);
			displayInOrder(root.left);
			displayInOrder(root.right);
		}

	}

	private int getBalance(Node root) {
		if (root == null) {
			return 0;
		}
		return getHeight(root.left) - getHeight(root.right);

	}

	private int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return root.height;
	}
}
