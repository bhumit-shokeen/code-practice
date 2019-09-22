package InterviewBit.string;

import java.util.ArrayList;

public class PreetyJson {
	public static void main(String[] args) {
		PreetyJson preetyJson = new PreetyJson();
		ArrayList<String> ans = preetyJson.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"},m:{G:\"H\",I:\"J\"}}}");
		// `ArrayList<String> ans =
		// preetyJson.prettyJSON("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]");

		for (String string : ans) {
			System.out.println(string);
		}
	}

	public ArrayList<String> prettyJSON(String a) {
		int tab = 0;
		int start = 0;
		int end = 0;
		char ch;
		ArrayList<String> ans = new ArrayList<String>();
		for (int i = 0; i < a.length(); i++) {
			ch = a.charAt(i);
			if (ch == '{' || ch == '[') {
				if (i != 0 && start != i)
					ans.add(getStringWithTab(tab, a.substring(start, i)));
				ans.add(getStringWithTab(tab, Character.toString(ch)));
				tab++;
				start = i + 1;
				end = i + 1;
			} else if (ch == ',') {
				ans.add(getStringWithTab(tab, a.substring(start, i + 1)));
				start = i + 1;
				end = i + 1;

			} else if (ch == '}' || ch == ']') {
				if (start != i)
					ans.add(getStringWithTab(tab, a.substring(start, i)));
				tab--;
				if (i != a.length() - 1 && a.charAt(i + 1) == ',') {
					start = i;
				} else {
					ans.add(getStringWithTab(tab, Character.toString(ch)));
					start = i + 1;
					end = i + 1;
				}
			} else {
				end++;
			}
		}
		return ans;
	}

	private String getStringWithTab(int tab, String a) {
		StringBuffer tabs = new StringBuffer();
		for (int i = 0; i < tab; i++) {
			tabs = tabs.append('\t');
		}
		tabs.append(a);
		return tabs.toString();

	}
}
/*
 * { A:"B", C: { D:"E", F: { G:"H", I:"J" } } }
 */