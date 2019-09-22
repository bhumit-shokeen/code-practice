package InterviewBit.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextMax {
	public static void main(String[] args) {
		NextMax nextMax = new NextMax();
		System.out.println(nextMax.find(new ArrayList<Integer>(Arrays.asList(7, 2, 4, 3, 2, 5, 1))));

	}

	public ArrayList<Integer> find(ArrayList<Integer> a) {
		Stack<Integer> st = new Stack<Integer>();
		int n = a.size();
		st.push(a.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			if (a.get(i) > st.peek()) {
				st.push(a.get(i));
			}
		}

		ArrayList<Integer> sol = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (a.get(i) == st.peek()) {
				sol.add(-1);
				st.pop();
			} else {
				sol.add(st.peek());
			}
		}

		return sol;

	}
}
