package tree;

class NodeAvl {
	int v;
	int h;
	NodeAvl left;
	NodeAvl right;

	public NodeAvl(int v) {
		this.v = v;
		h = 1;
		left = null;
		right = null;
	}
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone {
	public static void main(String[] args) throws java.lang.Exception {
		Ideone i = new Ideone();
		NodeAvl root = i.insert(null, 10);
		root = i.insert(root, 20);
		root = i.insert(root, 30);
		root = i.insert(root, 40);
		root = i.insert(root, 50);
		// root = i.insert(root,25);

		// i.disp(root);

		root = i.delete(root, 10);
		i.disp(root);

	}

	public void disp(NodeAvl root) {
		if (root != null) {

			System.out.println(root.v);
			disp(root.left);

			disp(root.right);
		}
	}

	public NodeAvl insert(NodeAvl root, int v) {
		if (root == null) {
			return new NodeAvl(v);
		}
		if (v < root.v) {
			root.left = insert(root.left, v);
		} else {
			root.right = insert(root.right, v);
		}

		root.h = Math.max(findHeight(root.left), findHeight(root.right)) + 1;

		int balance = findHeight(root.left) - findHeight(root.right);

		if (balance > 1 && v < root.left.v) {
			// rr
			root = rightRotate(root);
		} else if (balance > 1 && v > root.left.v) {
			// ll
			root.left = leftRotate(root.left);

			// rr
			root = rightRotate(root);

		} else if (balance < -1 && v > root.right.v) {
			// ll
			root = leftRotate(root);

		} else if (balance < -1 && v < root.right.v) {
			// rr
			root.right = rightRotate(root.right);
			// ll

			root = leftRotate(root);
		}

		return root;
	}

	private NodeAvl rightRotate(NodeAvl root) {
		NodeAvl y = root.left;
		NodeAvl x = y.right;

		root.left = x;
		y.right = root;

		root.h = Math.max(findHeight(root.left), findHeight(root.right)) + 1;
		y.h = Math.max(findHeight(y.left), findHeight(y.right)) + 1;

		return y;
	}

	private NodeAvl leftRotate(NodeAvl root) {
		NodeAvl y = root.right;
		NodeAvl x = y.left;

		root.right = x;
		y.left = root;

		root.h = Math.max(findHeight(root.left), findHeight(root.right)) + 1;
		y.h = Math.max(findHeight(y.left), findHeight(y.right)) + 1;

		return y;

	}

	private int findHeight(NodeAvl root) {
		if (root == null) {
			return 0;
		}
		return root.h;
	}

	public NodeAvl delete(NodeAvl root, int v) {
		if (v < root.v) {
			root.left = delete(root.left, v);
		} else if (v > root.v) {
			root.right = delete(root.right, v);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right != null) {
				NodeAvl temp = root.left;
				while (temp.right != null) {
					temp = temp.right;
				}
				root.v = temp.v;
				root.left = delete(root.left, temp.v);
			} else if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		root.h = Math.max(findHeight(root.left), findHeight(root.right)) + 1;

		int balance = findHeight(root.left) - findHeight(root.right);

		if (balance > 1 && findHeight(root.left.left) >= findHeight(root.left.right)) {
			// rr
			root = rightRotate(root);
		} else if (balance > 1 && findHeight(root.left.left) < findHeight(root.left.right)) {
			// ll
			root.left = leftRotate(root.left);

			// rr
			root = rightRotate(root);

		} else if (balance < -1 && findHeight(root.right.left) <= findHeight(root.right.right)) {
			// ll
			root = leftRotate(root);

		} else if (balance < -1 && findHeight(root.right.left) > findHeight(root.right.right)) {
			// rr
			root.right = rightRotate(root.right);
			// ll

			root = leftRotate(root);
		}

		return root;

	}

}
