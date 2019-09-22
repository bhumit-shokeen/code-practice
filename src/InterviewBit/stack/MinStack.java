package InterviewBit.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(8);
		minStack.push(3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());

	}

	Deque<Integer> stack;
	Deque<Integer> minStack;

	public MinStack() {
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();

	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || minStack.peek() > x) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int pop = stack.poll();
			if (pop == minStack.peek()) {
				minStack.poll();
			}
		}

	}

	public int top() {
		if (stack.isEmpty())
			return -1;
		return stack.peek();

	}

	public int getMin() {
		if (stack.isEmpty())
			return -1;
		return minStack.peek();

	}
}
