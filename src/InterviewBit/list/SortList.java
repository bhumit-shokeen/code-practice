package InterviewBit.list;

public class SortList {
	public static void main(String[] args) {
		SortList sortList = new SortList();
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

	public ListNode sortList(ListNode a) {
		if (a == null || a.next == null) {
			return a;
		}
		ListNode mid = findMid(a);
		ListNode nextMid = mid.next;
		mid.next = null;

		ListNode left = sortList(a);
		ListNode right = sortList(nextMid);
		return merge(left, right);
	}

	private ListNode findMid(ListNode s) {
		if (s == null) {
			return s;
		}
		ListNode slow = s;
		ListNode fast = s.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	private ListNode merge(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		ListNode result = null;
		if (a.val < b.val) {
			result = a;
			result.next = merge(a.next, b);
		} else {
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}
}
