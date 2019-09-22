package InterviewBit.dynamic;

import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		Brackets brackets = new Brackets();
		System.out.println(brackets.longestValidParentheses("((()(((((()(()((()(()))))())))()())((()))))))(())()()("));
	}

	class Node {
		char c;
		int i;

		Node(char c, int i) {
			this.c = c;
			this.i = i;
		}

	}

	public int longestValidParentheses(String a) {
		Stack<Node> stack = new Stack<Node>();
		int[] dp = new int[a.length()];
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (a.charAt(i) == '(') {
				stack.push(new Node('(', i));
			} else if (!stack.isEmpty() && stack.peek().c == '(') {
				Node n = stack.pop();
				dp[i] = dp[i - 1] + 2;
				if (n.i != 0) {
					dp[i] = dp[i] + dp[n.i - 1];
				}
				if (dp[i] > max) {
					max = dp[i];
				}
			} else {
				stack.push(new Node(')', i));
			}
		}
		return max;
	}
}
