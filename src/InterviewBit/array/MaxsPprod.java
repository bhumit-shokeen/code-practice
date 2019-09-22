package InterviewBit.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class MaxsPprod {
	public static void main(String[] args) {
		MaxsPprod maxsPprod = new MaxsPprod();
		System.out
				.println(maxsPprod.maxSpecialProduct2(new ArrayList<>(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))));
		System.out
				.println(maxsPprod.maxSpecialProduct3(new ArrayList<>(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))));

	}

	public int maxSpecialProduct2(ArrayList<Integer> a) {
		int[] lsv = new int[a.size()];
		int[] rsv = new int[a.size()];
		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(0);
		for (int i = 1; i < a.size(); i++) {
			while (!q.isEmpty()) {
				if (a.get(i) < a.get(q.getLast())) {
					break;
				}
				q.removeLast();
			}
			lsv[i] = q.isEmpty() ? 0 : q.getLast();
			q.addLast(i);

		}
		q = new ArrayDeque<>();
		q.addLast(a.size() - 1);
		for (int i = a.size() - 2; i >= 0; i--) {
			while (!q.isEmpty()) {
				if (a.get(i) < a.get(q.getLast())) {
					break;
				}
				q.removeLast();
			}
			rsv[i] = q.isEmpty() ? 0 : q.getLast();
			q.addLast(i);
		}

		// 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9
		// [0, 0, 0, 0, 0, 4, 5, 0, 0, 0, 9] [9, 9, 4, 4, 5, 6, 9, 9, 9, 0, 0]
		// [0, 0, 1, 1, 3, 4, 3, 0, 7, 8, 0] [1, 0, 3, 7, 7, 6, 7, 0, 10, 10, 0]
		long sol = 0;
		long temp;
		for (int i = 0; i < a.size(); i++) {
			temp = lsv[i] * rsv[i] * 1L;
			if (sol < temp) {
				sol = temp;
			}
		}
		return (int) (sol % (1000000007L));

	}

	public int maxSpecialProduct3(ArrayList<Integer> A) {
		int n = A.size();
		int[] left = new int[n];
		int[] right = new int[n];

		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(0);

		for (int i = 1; i < n; i++) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i))
					break;
				q.removeLast();
			}
			left[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		q = new ArrayDeque<>();
		q.addLast(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i))
					break;
				q.removeLast();
			}
			right[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		long mx = -1;
		for (int i = 0; i < n; i++) {
			mx = Long.max(mx, 1L * left[i] * right[i]);
		}
		return (int) (mx % 1000000007);
	}

	public int maxSpecialProduct(ArrayList<Integer> a) {
		long sol = 0;
		long temp;
		for (int i = 0; i < a.size(); i++) {
			temp = lsv(a, i) * rsv(a, i);
			if (temp > sol) {
				sol = temp;
			}
		}

		return (int) (sol % (1000000007L));
	}

	private int rsv(ArrayList<Integer> a, int i) {
		for (int j = i; j < a.size(); j++) {
			if (a.get(j) > a.get(i)) {
				return j;
			}
		}
		return 0;
	}

	private int lsv(ArrayList<Integer> a, int i) {
		for (int j = i; j >= 0; j--) {
			if (a.get(j) > a.get(i)) {
				return j;
			}
		}
		return 0;
	}
}
