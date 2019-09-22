package InterviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NearestSmallerElement {
	public static void main(String[] args) {
		NearestSmallerElement smallerElement = new NearestSmallerElement();
		ArrayList<Integer> sol = smallerElement.prevSmaller(new ArrayList<Integer>(Arrays.asList(4, 5, 2, 10, 8)));
		for (int i = 0; i < sol.size(); i++) {
			System.out.println(sol.get(i));
		}
	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int i = 0;
		ArrayList<Integer> sol = new ArrayList<Integer>();
		int current = 0;
		int tp;
		while (i < a.size()) {
			current = a.get(i);
			if (stack.isEmpty() || (a.get(stack.peek()) < current)) {
				sol.add(stack.isEmpty() ? -1 : a.get(stack.peek()));
				stack.push(i);
				i++;
			} else {
				tp = stack.poll();
			}
		}
		while (!stack.isEmpty()) {
			tp = stack.poll();

		}
		return sol;
	}

}
