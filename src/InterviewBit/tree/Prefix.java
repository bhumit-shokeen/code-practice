package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;

class Tree {
	boolean end = false;
	Tree[] next = new Tree[26];

	public void insert(Tree root, String s) {
		if (s.isEmpty()) {
			return;
		}

		char c = s.charAt(0);

		Tree targetNode = root.next[c - 97];

		if (targetNode == null) {
			root.next[c - 97] = new Tree();
			if (s.length() == 1) {
				root.next[c - 97].end = true;
			}

			insert(root.next[c - 97], s.substring(1));

		} else {
			if (s.length() == 1) {
				root.next[c - 97].end = true;
			}
			insert(root.next[c - 97], s.substring(1));

		}
		return;

	}
}

public class Prefix {
	public static void main(String[] args) {
		Prefix prefix = new Prefix();
		System.out.println(prefix.prefix(new ArrayList<String>(Arrays.asList("bearcat", "bert"))));
	}

	public ArrayList<String> prefix(ArrayList<String> a) {
		Tree root = new Tree();
		for (String s : a) {
			root.insert(root, s);
		}
		ArrayList<String> sol = new ArrayList<String>();
		for (String s : a) {
			String temp;
			sol.add(find(root, s));
		}
		return sol;
	}

	private String find(Tree root, String s) {
		StringBuffer sol = new StringBuffer();
		Tree temp = root;
		int i = 0;
		int lastIndex = 0;
		while (temp.end == false) {
			if (hasTwoNotNull(temp)) {
				lastIndex = i;
			}
			sol.append(s.charAt(i));
			temp = temp.next[s.charAt(i) - 97];
			i++;
		}
		return sol.substring(0, lastIndex + 1);
	}

	private boolean hasTwoNotNull(Tree temp) {
		boolean one = false;
		for (int i = 0; i < 26; i++) {
			if (temp.next[i] != null) {
				if (one == false) {
					one = true;
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
