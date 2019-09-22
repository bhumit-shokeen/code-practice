package InterviewBit.list;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Palindrome {
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();

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
		System.out.println((palindrome.lPalin(A)));

	}

	public int lPalin(ListNode a) {
		int n = 0;
		ListNode head = a;
		while (head != null) {
			head = head.next;
			n++;
		}
		ListNode mid = a;
		if (n % 2 == 0) {
			for (int i = 1; i < n / 2; i++) {
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
		int ans = 1;
		head = a;
		while ((head != null) && (ans == 1)) {
			if (head.val != pre.val) {
				ans = 0;
			}
			head = head.next;
			pre = pre.next;
		}
		return ans;
	}
}
