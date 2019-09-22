package InterviewBit.list;

public class ReorderList {
	public static void main(String[] args) {
		ReorderList reorderList = new ReorderList();
		ListNode A = new ListNode(6);
		A.next = new ListNode(3);

		A.next.next = new ListNode(7);
		A.next.next.next = new ListNode(3);
		A.next.next.next.next = new ListNode(6);

		ListNode head = A;
		while (head != null) {
			System.out.println(" " + head.val);
			head = head.next;
		}
		head = reorderList.reorderList(A);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public ListNode reorderList(ListNode a) {
		int n = 0;
		ListNode head = a;
		while (head != null) {
			head = head.next;
			n++;
		}
		ListNode mid = a;
		if (n % 2 == 0) {
			for (int i = 1; i <= n / 2; i++) {
				mid = mid.next;
			}
		} else {
			for (int i = 1; i < (n + 1) / 2; i++) {
				mid = mid.next;
			}

		}
		head = mid.next;
		ListNode pre = mid;
		while (head != null) {
			mid.next = head.next;
			head.next = pre;
			pre = head;
			head = mid.next;
		}
		// new logic form here

		ListNode l, r, lPre, rPost;
		l = a.next;
		r = pre.next;
		lPre = a;
		rPost = pre;

		while ((l != null) && (r != null)) {
			lPre.next = rPost;
			rPost.next = l;
			lPre = l;
			l = l.next;
			rPost = r;
			r = r.next;

		}
		return a;
	}
}
