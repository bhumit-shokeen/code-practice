package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SuperString {
	public static void main(String[] args) {
		SuperString superString = new SuperString();
		System.out.println(superString
				.solve(new ArrayList<String>(Arrays.asList("qfgxmuvgfaj", "lfvenhyuhuor", "osamibdnj", "beyhkbso"))));
		// System.out.println(superString.solve(new
		// ArrayList<String>(Arrays.asList("abcd", "cdef", "fgh", "de"))));
	}

	public int solve(ArrayList<String> a) {
		Collections.sort(a);
		String sol = a.get(0);

		for (int i = 1; i < a.size(); i++) {
			// sol = superString(sol, 0, a.get(i), 0);
			sol = superString1(sol, a.get(i));
		}

		return sol.length();
	}

	private String superString1(String a, String b) {
		boolean flag = true;
		int index = 0;
		int l1 = a.length();
		int l2 = b.length();
		for (int i = 1; i <= a.length(); i++) {
			flag = true;

			for (int j = i - 1; j >= 0; j--) {
				if (i - j - 1 >= l2) {

					break;
				}
				if (a.charAt(l1 - 1 - j) != b.charAt(i - j - 1)) {
					flag = false;
					break;
				}

			}
			if (flag)
				index = i;
		}
		if (index == 0) {
			return a + b;
		}
		if (index >= l2) {
			return a;
		}

		return a + b.substring(index);
	}

	private String superString(String temp, int l1, String b, int l2) {
		if (l1 >= temp.length() && l2 >= b.length()) {
			return "";
		}
		if (l1 >= temp.length()) {
			return b.substring(l2, b.length());
		}
		if (l2 >= b.length()) {
			return temp.substring(l1, temp.length());
		}
		if (temp.charAt(l1) == b.charAt(l2)) {
			return temp.charAt(l1) + superString(temp, l1 + 1, b, l2 + 1);
		} else {
			String s1 = temp.charAt(l1) + superString(temp, l1 + 1, b, l2);
			String s2 = b.charAt(l2) + superString(temp, l1, b, l2 + 1);
			return s1.length() < s2.length() ? s1 : s2;
		}

	}

}
