//http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
package two;

class Node {
	int key, height;
	Node left, right;

	Node(int key) {
		this.key = key;
		height = 1;
	}
}

public class AVLTree {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		Node root = tree.insert(null, 10);
		root = tree.insert(root, 20);
		root = tree.insert(root, 30);
		root = tree.insert(root, 40);
		root = tree.insert(root, 50);
		root = tree.insert(root, 25);

		tree.display(root);

	}

	void display(Node node) {
		if (node == null)
			return;
		System.out.println(node.key);
		display(node.left);
		display(node.right);
	}

	int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);

	}

	boolean isAGreaterThanB(int a, int b) {
		if (a > b) {
			return true;
		}
		return false;
	}

	Node leftRotate(Node node) {
		Node x, y, z;
		x = node;
		y = node.right;
		z = y.left;

		y.left = x;
		x.right = z;

		x.height = (getHeight(x.left) > getHeight(x.right) ? getHeight(x.left) : getHeight(x.right)) + 1;
		y.height = (getHeight(y.left) > getHeight(y.right) ? getHeight(y.left) : getHeight(y.right)) + 1;
		return y;
	}

	Node rightRotate(Node node) {
		Node x, y, z;
		x = node;
		y = x.left;
		z = y.right;

		y.right = x;
		x.left = z;

		x.height = (getHeight(x.left) > getHeight(x.right) ? getHeight(x.left) : getHeight(x.right)) + 1;
		y.height = (getHeight(y.left) > getHeight(y.right) ? getHeight(y.left) : getHeight(y.right)) + 1;
		return y;
	}

	Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		if (isAGreaterThanB(node.key, value)) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}
		node.height = (getHeight(node.left) > getHeight(node.right) ? getHeight(node.left) : getHeight(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && node.left.key > value) {
			node = rightRotate(node);
		} else if (balance > 1 && node.left.key < value) {
			node.left = leftRotate(node.left);
			node = rightRotate(node);
		} else if (balance < -1 && node.right.key < value) {
			node = leftRotate(node);
		} else if (balance < -1 && node.right.key > value) {
			node.right = rightRotate(node.right);
			node = leftRotate(node);
		}

		return node;
	}
}
