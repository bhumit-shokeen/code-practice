package InterviewBit.tree;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class RightPointer {
	public static void main(String[] args) {
		RightPointer rightPointer = new RightPointer();
		TreeLinkNode root = new TreeLinkNode(12);
		root.left = new TreeLinkNode(5);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(8);
		root.right = new TreeLinkNode(14);
		root.right.right = new TreeLinkNode(18);
		root.right.right.left = new TreeLinkNode(16);

		rightPointer.connect(root);
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode temp = root;
		TreeLinkNode next = root.left != null ? root.left : root.right;
		while (temp.left != null || temp.right != null | temp.next != null) {

			while (temp != null) {

				if (temp.left != null) {
					if (temp.right != null) {
						temp.left.next = temp.right;
					} else if (temp.next != null) {
						if (temp.next.left != null) {
							temp.left.next = temp.next.left;
						} else if (temp.next.right != null) {
							temp.left.next = temp.next.right;
						}
					}
				}
				if (temp.right != null) {
					if (temp.next != null) {
						if (temp.next.left != null) {
							temp.right.next = temp.next.left;
						} else if (temp.next.right != null) {
							temp.right.next = temp.next.right;
						}
					}
				}
				temp = temp.next;
			}
			if (next == null) {
				break;
			}
			temp = next;

			if (temp.left != null) {
				next = temp.left;
			} else if (temp.right != null) {
				next = temp.right;
			} else if (temp.next != null) {
				TreeLinkNode nextTemp = temp;
				next = null;
				while (nextTemp.next != null && next == null) {

					if (nextTemp.next.left != null) {
						next = nextTemp.next.left;
					} else if (nextTemp.next.right != null) {
						next = nextTemp.next.right;
					}
					nextTemp = nextTemp.next;
				}

			}
		}
	}
}
