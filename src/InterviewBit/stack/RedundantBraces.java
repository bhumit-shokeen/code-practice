package InterviewBit.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RedundantBraces {
	public static void main(String[] args) {
		RedundantBraces name = new RedundantBraces();
		System.out.println(name.braces("(a+b"));
	}

	class MySet {
		char value;
		boolean result;

		MySet(char value) {
			this.value = value;
			result = false;
		}
	}

	public int braces(String a) {
		Deque<MySet> stack = new LinkedList<MySet>();
		char cur;
		MySet ptr = null;
		for (int i = 0; i < a.length(); i++) {
			cur = a.charAt(i);
			if (cur == '(') {
				if (ptr == null) {
					ptr = new MySet('(');

				} else {
					stack.push(ptr);
					ptr = new MySet('(');
				}
			} else if (ptr != null && (cur == '+' || cur == '-' || cur == '*' || cur == '/')) {
				ptr.result = true;
			} else if (cur == ')') {
				if (ptr.result == false) {
					return 1;
				} else {
					ptr = stack.poll();
				}
			}
		}
		return 0;
	}
}
