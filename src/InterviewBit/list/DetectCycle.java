package InterviewBit.list;

public class DetectCycle {

	public static void main(String[] args) {
		DetectCycle detectCycle = new DetectCycle();
		ListNode A = new ListNode(1);
		A.next = new ListNode(2);

		A.next.next = new ListNode(3);
		A.next.next.next = new ListNode(4);
		A.next.next.next.next = A.next.next;

		ListNode head = detectCycle.detectCycle(A);
		System.out.println(head.val);

	}

	public ListNode detectCycle(ListNode a) {
		ListNode slow = a.next, fast = null;
		if (slow != null) {
			fast = slow.next;
		}
		while (fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		ListNode head2 = slow;
		int n = 0;
		if (slow == fast) {
			head2 = slow.next;
			n = 1;
			while (head2 != slow) {
				n++;
				head2 = head2.next;
			}
			slow = a;
			fast = a;
			while (n > 0) {
				fast = fast.next;
				n--;
			}
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}

		return null;
	}

}
