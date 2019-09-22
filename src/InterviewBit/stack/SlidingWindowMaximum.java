package InterviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		SlidingWindowMaximum windowMaximum = new SlidingWindowMaximum();
		// ArrayList<Integer> sol =
		// windowMaximum.slidingMaximum1(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3,
		// 2, 1), 2);
		ArrayList<Integer> sol = windowMaximum.slidingMaximum1(Arrays.asList(1), 1);
		for (int i = 0; i < sol.size(); i++) {
			System.out.println(sol.get(i));
		}

	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int w) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int i = w;
		int curr;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		fillStack(a, stack, 0, w);
		sol.add(stack.peek());
		while (i < a.size()) {
			curr = a.get(i);
			if (stack.isEmpty() || stack.peek() < curr) {
				stack.push(curr);
			}

			if (stack.peekLast() == a.get(i - w)) {
				stack.removeLast();
				if (stack.isEmpty()) {
					fillStack(a, stack, i - w + 1, w);
				}
			}

			sol.add(stack.peek());
			i++;

		}

		return sol;
	}

	private void fillStack(List<Integer> a, Deque<Integer> stack, int i, int w) {
		int current;
		for (int j = 0; j < w; j++) {
			current = a.get(i + j);
			if (stack.isEmpty() || stack.peek() < current) {
				stack.push(current);
			}
		}

	}

	public ArrayList<Integer> slidingMaximum1(final List<Integer> a, int w) {
		int n = a.size();
		if (w > n) {
			w = n;
		}

		int m = 1;
		while (n / (Math.pow(2, m)) >= 1) {
			m++;
		}
		m = (int) (2 * (Math.pow(2, m)) - 1);
		int[] seg = new int[m];
		makeTree(seg, a, 0, n - 1, 0);

		for (int i = 0; i < m; i++) {
			// System.out.println(i+" "+seg[i]);
		}

		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i = 0; i <= n - w; i++) {
			sol.add(find(seg, i, i + w - 1, 0, 0, n - 1));
		}
		return sol;

	}

	private void makeTree(int[] seg, List<Integer> a, int s, int e, int pos) {
		if (s == e) {
			seg[pos] = a.get(s);
			return;
		}
		int mid = (s + e) / 2;
		makeTree(seg, a, s, mid, 2 * pos + 1);
		makeTree(seg, a, mid + 1, e, 2 * pos + 2);
		seg[pos] = Math.max(seg[2 * pos + 1], seg[2 * pos + 2]);

	}

	private int find(int[] seg, int qs, int qe, int pos, int s, int e) {
		if (qs <= s && qe >= e) {
			return seg[pos];
		} else if (qs > e || qe < s) {
			return Integer.MIN_VALUE;
		}
		int mid = (s + e) / 2;
		return Math.max(find(seg, qs, qe, 2 * pos + 1, s, mid), find(seg, qs, qe, 2 * pos + 2, mid + 1, e));
	}

}
