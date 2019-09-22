package InterviewBit.string;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPre {
	public static void main(String[] args) {
		LongestPre name = new LongestPre();
		System.out.println(name.longestCommonPrefix(new ArrayList<String>(Arrays.asList("abcdefgh", "abcdefg"))));
	}

	public String longestCommonPrefix(ArrayList<String> a) {
		int index = 0;
		int current;
		boolean flag = true;
		while (flag && index < a.get(0).length()) {
			current = a.get(0).charAt(index);
			for (int i = 0; i < a.size(); i++) {
				if (index >= a.get(i).length()) {
					flag = false;
					break;
				}
				if (current != a.get(i).charAt(index)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				index++;
			}
		}

		return a.get(0).substring(0, index);
	}
}
