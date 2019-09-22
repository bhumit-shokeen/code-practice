package InterviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangle {
	public static void main(String[] args) {
		LargestRectangle largestRectangle = new LargestRectangle();
		System.out.println(largestRectangle.largestRectangleArea(new ArrayList<Integer>(Arrays.asList(1))));

	}

	public int largestRectangleArea1(ArrayList<Integer> a) {

		if (a.size() == 0) {
			return 0;
		}
		int sol = -1;
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		for (int i = 1; i < a.size(); i++) {
			while (!st.isEmpty() && a.get(st.peek()) > a.get(i)) {

				int index = st.pop();
				if (st.isEmpty()) {
					sol = Math.max(sol, (a.get(index) * (i)));
				} else {
					sol = Math.max(sol, (a.get(index) * (i - st.peek() - 1)));
				}

			}
			st.push(i);
		}
		// System.out.println(sol);
		int n = st.peek();
		while (!st.isEmpty()) {

			int index = st.pop();
			if (st.isEmpty()) {
				sol = Math.max(sol, (a.get(index) * (n + 1)));
			} else {
				sol = Math.max(sol, (a.get(index) * (n - st.peek())));
			}

		}
		return sol;
	}

	public int largestRectangleArea(ArrayList<Integer> a) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int area = Integer.MIN_VALUE;
		int tempArea;
		int pop;
		int i = 0;
		while (i < a.size()) {
			if (stack.isEmpty() || a.get((int) stack.peek()) <= a.get(i)) {
				stack.push(i);
				i++;
			} else {
				pop = stack.poll();
				tempArea = (a.get(pop)) * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				if (tempArea > area) {
					area = tempArea;
				}
			}
		}
		while (!stack.isEmpty()) {
			pop = stack.poll();
			tempArea = (a.get(pop)) * (stack.isEmpty() ? i : (i - stack.peek() - 1));
			if (tempArea > area) {
				area = tempArea;
			}
		}
		return area;
	}

}
