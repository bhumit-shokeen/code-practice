package InterviewBit.list;

public class SortList2 {
	public static void main(String[] args) {
		SortList2 sortList = new SortList2();
		ListNode A = new ListNode(6);
		A.next = new ListNode(3);

		A.next.next = new ListNode(7);
		A.next.next.next = new ListNode(1);
		// A.next.next.next.next = new ListNode(8);

		ListNode head = A;
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		head = sortList.sortList(A);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l = head;

		while (l1 != null && l2 != null) {
			int val = 0;
			if (l1.val <= l2.val) {
				val = l1.val;
				l1 = l1.next;
			} else {
				val = l2.val;
				l2 = l2.next;
			}
			l.next = new ListNode(val);
			l = l.next;
		}

		if (l1 != null) {
			l.next = l1;
		} else if (l2 != null) {
			l.next = l2;
		}

		return head.next;
	}

	public ListNode sortList(ListNode h) {
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		ListNode middle = getMiddle(h);
		ListNode nextofmiddle = middle.next;

		// set the next of middle ListNode to null
		middle.next = null;

		// Apply mergeSort on left list
		ListNode left = sortList(h);

		// Apply mergeSort on right list
		ListNode right = sortList(nextofmiddle);

		// Merge the left and right lists
		ListNode sortedlist1 = merge(left, right);
		return sortedlist1;
	}

	// Utility function to get the middle of the linked list
	ListNode getMiddle(ListNode h) {
		// Base case
		if (h == null)
			return h;
		ListNode fastptr = h.next;
		ListNode slowptr = h;

		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middle ListNode
		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}
}
