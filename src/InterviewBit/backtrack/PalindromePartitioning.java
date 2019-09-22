package InterviewBit.backtrack;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning letterPhone = new PalindromePartitioning();
		for (ArrayList<String> inner : letterPhone.partition("efe")) {
			System.out.println("");
			for (String string : inner) {
				System.out.print(" " + string);
			}

		}

	}

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> sol = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();
		findSol(a, 0, temp, sol);
		return sol;
	}

	private void findSol(String a, int i, ArrayList<String> temp, ArrayList<ArrayList<String>> sol) {
		if (i >= a.length()) {
			sol.add(new ArrayList<String>(temp));
		} else {
			StringBuffer current = new StringBuffer();
			for (int j = i; j < a.length(); j++) {
				current.append(a.charAt(j));
				if (isPalindrome(current)) {
					temp.add(current.toString());
					findSol(a, j + 1, temp, sol);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(StringBuffer current) {
		int n = current.length();
		for (int i = 0; i < (n / 2); i++) {
			if (current.charAt(i) != current.charAt(n - 1 - i)) {
				return false;
			}
		}

		return true;
	}
}
