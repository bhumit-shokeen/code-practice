//http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
package two;

public class AVLTreeDeletion {

	public static void main(String[] args) {
		AVLTreeDeletion tree = new AVLTreeDeletion();
		Node root = tree.insert(null, 10);
		root = tree.insert(root, 20);
		root = tree.insert(root, 30);
		root = tree.insert(root, 40);
		root = tree.insert(root, 50);
		root = tree.insert(root, 25);

		tree.display(root);

		root = tree.delete(root, 50);
		root = tree.delete(root, 40);

		tree.display(root);

	}

	private int findInOrderSuccessor(Node node) {
		if (node.left == null) {
			return node.key;
		}
		return findInOrderSuccessor(node.left);

	}

	private Node delete(Node node, int key) {
		if (node == null) {
			return null;
		}
		if (key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else {
			Node temp = node;
			if (node.left != null && node.right != null) {
				int preKey = findInOrderSuccessor(node.right);
				node.key = preKey;
				node.right = delete(node.right, preKey);
			} else if (node.left == null && node.right == null) {
				node = null;
				return node;
			} else if (node.left == null) {
				node = node.right;
				temp = null;
			} else {
				node = node.left;
				temp = null;
			}

		}
		node.height = (getHeight(node.left) > getHeight(node.right) ? getHeight(node.left) : getHeight(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && getBalance(node.left) >= 0) {
			node = rightRotate(node);
		} else if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			node = rightRotate(node);
		} else if (balance < -1 && getBalance(node.right) <= 0) {
			node = leftRotate(node);
		} else if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			node = leftRotate(node);
		}

		return node;

	}

	private Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		}
		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		} else {
			return node;
		}

		node.height = (getHeight(node.left) > getHeight(node.right) ? getHeight(node.left) : getHeight(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key) {
			node = rightRotate(node);
		} else if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			node = rightRotate(node);
		} else if (balance < -1 && key > node.right.key) {
			node = leftRotate(node);
		} else if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			node = leftRotate(node);
		}

		return node;
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

}
