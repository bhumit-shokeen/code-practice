package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		System.out.println(wordBreak.wordBreak("aabbbabaaabbbabaabaab", new ArrayList<String>(
				Arrays.asList("bababbbb", "bbbabaa", "abbb", "a", "aabbaab", "b", "babaabbbb", "aa", "bb"))));
	}

	public ArrayList<String> wordBreak(String a, ArrayList<String> b) {

		ArrayList<StringBuffer> ret = sol(0, a, b);
		ArrayList<String> sol = new ArrayList<String>();
		for (int i = 0; i < ret.size(); i++) {
			sol.add(ret.get(i).toString());
		}
		return sol;
	}

	private ArrayList<StringBuffer> sol(int b, String s, ArrayList<String> dict) {
		ArrayList<StringBuffer> sol = new ArrayList<StringBuffer>();
		if (b == s.length()) {
			sol.add(new StringBuffer(""));
			return sol;
		}

		StringBuffer buffer = null;
		ArrayList<StringBuffer> list = null;
		for (int i = b; i < s.length(); i++) {
			buffer = new StringBuffer(s.substring(b, i + 1));
			if (dict.contains(buffer.toString())) {
				list = sol(i + 1, s, dict);
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).length() != 0) {
							list.get(j).insert(0, " ");

						}
						list.get(j).insert(0, buffer);
					}
					sol.addAll(list);
				}

			}
		}
		return sol;
	}
}
