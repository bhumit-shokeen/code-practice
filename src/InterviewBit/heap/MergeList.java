package InterviewBit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeList {

	public static void main(String[] args) {
		MergeList mergeList = new MergeList();
		ListNode h1 = new ListNode(0);
		h1.next = new ListNode(6);
		ListNode h2 = new ListNode(5);
		h2.next = new ListNode(2);
		ListNode h3 = new ListNode(4);
		h3.next = new ListNode(9);

		ListNode h4 = mergeList.mergeKLists(new ArrayList<ListNode>(Arrays.asList(h1, h2, h3)));
		while (h4 != null) {
			System.out.println(h4.val);
			h4 = h4.next;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (ListNode h : a) {
			while (h != null) {
				pq.add(h.val);
				h = h.next;
			}
		}
		ArrayList<Integer> sol = new ArrayList<Integer>(pq);
		Collections.sort(sol);

		ListNode ret = sol.size() > 0 ? new ListNode(sol.get(0)) : null;

		ListNode pre = ret;
		for (int i = 1; i < sol.size(); i++) {
			pre.next = new ListNode(sol.get(i));
			pre = pre.next;
		}
		return ret;
	}
}
