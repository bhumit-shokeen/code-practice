package revise;

public class AvlTree {

	class Node {
		int value, height;
		Node left, right;

		Node(int value) {
			this.value = value;
			this.height = 1;
		}
	}

	int getHeight(Node node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}

	Node insert(Node node, int value) {
		if (node == null)
			return new Node(value);

		else if (node.value > value) {
			node.left = insert(node.left, value);
		} else if (node.value < value) {
			node.right = insert(node.right, value);
		}

		node.height = (getHeight(node.left) > getHeight(node.right) ? getHeight(node.left) : getHeight(node.right)) + 1;

		return node;
	}

	void display(Node node) {
		if (node == null)
			return;
		display(node.left);
		System.out.println(node.value + " : " + node.height);
		display(node.right);

	}

	Node delete(Node node, int value) {
		if (node == null)
			return null;
		else if (node.value > value) {
			node.left = delete(node.left, value);
		} else if (node.value < value) {
			node.right = delete(node.right, value);
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left != null && node.right != null) {
				int preKey = findPresuccessor(node.left);
				node.value = preKey;
				node.left = delete(node.left, preKey);
			} else if (node.left == null) {
				node = node.right;

			} else {
				node = node.left;
			}
		}

		node.height = (getHeight(node.left) > getHeight(node.right) ? getHeight(node.left) : getHeight(node.right)) + 1;

		return node;

	}

	private int findPresuccessor(Node node) {
		if (node.left == null) {
			return node.value;
		}

		return findPresuccessor(node.left);
	}

	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		Node root = tree.insert(null, 8);
		root = tree.insert(root, 5);
		root = tree.insert(root, 9);
		root = tree.insert(root, 3);
		root = tree.insert(root, 2);

		tree.display(root);

		root = tree.delete(root, 2);

		tree.display(root);
	}

}
