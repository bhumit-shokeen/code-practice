package InterviewBit.backtrack;

import java.util.ArrayList;

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();
		for (String string : generateParentheses.generateParenthesis(3)) {
			System.out.println(" " + string);
		}
	}

	public ArrayList<String> generateParenthesis(int a) {
		ArrayList<String> sol = new ArrayList<String>();
		StringBuffer temp = new StringBuffer();
		findSol(a, a, temp, sol);

		return sol;
	}

	private void findSol(int o, int c, StringBuffer temp, ArrayList<String> sol) {
		if (c <= 0 && o <= 0) {
			sol.add(temp.toString());
		} else if (c <= 0 || o > c) {
			return;
		} else {
			if (o > 0) {
				temp.append("(");
				findSol(o - 1, c, temp, sol);
				temp.deleteCharAt(temp.length() - 1);
			}
			temp.append(")");
			findSol(o, c - 1, temp, sol);
			temp.deleteCharAt(temp.length() - 1);
		}

	}
}
