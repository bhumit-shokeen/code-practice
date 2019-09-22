package InterviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class EvaluateExpression {
	public static void main(String[] args) {
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		System.out.println(evaluateExpression.evalRPN(new ArrayList<String>(Arrays.asList("4", "13", "5", "/", "+"))));
	}

	public int evalRPN(ArrayList<String> a) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int i = 0;
		int op1;
		int op2;
		while (i < a.size()) {
			if (a.get(i).equals("+")) {
				op2 = stack.poll();
				op1 = stack.poll();
				stack.push(op1 + op2);
			} else if (a.get(i).equals("-")) {
				op2 = stack.poll();
				op1 = stack.poll();
				stack.push(op1 - op2);
			} else if (a.get(i).equals("*")) {
				op2 = stack.poll();
				op1 = stack.poll();
				stack.push(op1 * op2);
			} else if (a.get(i).equals("/")) {
				op2 = stack.poll();
				op1 = stack.poll();
				stack.push(op1 / op2);
			} else {
				stack.push(Integer.valueOf(a.get(i)));
			}
			i++;

		}
		return stack.poll();
	}
}
