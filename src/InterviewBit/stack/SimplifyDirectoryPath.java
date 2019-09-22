package InterviewBit.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyDirectoryPath {
	public static void main(String[] args) {
		SimplifyDirectoryPath name = new SimplifyDirectoryPath();
		System.out.println(name.simplifyPath1("/home//foo/"));
	}

	public String simplifyPath(String a) {
		String[] temp = a.split("/");
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals("..")) {
				j = i;
				temp[j] = null;
				while (j > 0 && temp[j] == null) {
					j--;
				}
				temp[j] = null;
			} else if (temp[i].equals(".") || temp[i].equals("")) {
				temp[i] = null;
			}
		}
		StringBuffer sol = new StringBuffer();
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] != null) {
				sol.append("/" + temp[i]);
			}
		}

		return sol.length() == 0 ? "/" : sol.toString();
	}

	public String simplifyPath1(String a) {
		StringBuffer sb = new StringBuffer();
		String[] s = a.split("/");

		int n = s.length;

		Deque<String> st = new LinkedList<String>();
		for (int i = 1; i < n; i++) {
			if (s[i].equals("..") && !st.isEmpty()) {
				st.pop();
			} else if (!s[i].equals(".") && !s[i].equals("") && !s[i].equals("..")) {
				st.push(s[i]);
			}
		}

		while (!st.isEmpty()) {
			sb.append("/");
			sb.append(st.pollLast());

		}
		return sb.length() == 0 ? "/" : sb.toString();
	}
}
