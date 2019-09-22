//https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
package two;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
		Node root = tree.insert(null, 10);
		root = tree.insert(root, 20);
		root = tree.insert(root, 30);
		root = tree.insert(root, 40);
		root = tree.insert(root, 50);
		// root = tree.insert(root, 25);

		System.out.println(tree.maxWidth(root));
		tree.display(root);
	}

	void display(Node node) {
		if (node != null) {
			display(node.left);
			System.out.println(node.key);
			display(node.right);
		}
	}

	Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		} else if (value < node.key) {
			node.left = insert(node.left, value);
		} else if (value > node.key) {
			node.right = insert(node.right, value);
		}
		return node;
	}

	int maxWidth(Node node) {
		Queue<Node> q = new LinkedList();
		int count;
		int width = 0;
		q.add(node);
		Node pop;
		while (!q.isEmpty()) {
			count = q.size();
			if (width < count) {
				width = count;
			}
			while (count-- > 0) {
				pop = q.remove();
				if (pop.left != null) {
					q.add(pop.left);
				}
				if (pop.right != null) {
					q.add(pop.right);
				}

			}
		}

		return width;

	}

}
