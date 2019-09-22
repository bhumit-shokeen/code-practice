package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak2 {

	public static void main(String[] args) {
		WordBreak2 w = new WordBreak2();
		System.out.println(
				w.wordBreak("myinterviewtrainer", new ArrayList<String>(Arrays.asList("interview", "my", "trainer"))));

	}

	public int wordBreak(String a, ArrayList<String> b) {
		if (b.size() == 0) {
			return 0;
		}
		if (a.length() == 0) {
			return 1;
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < b.size(); i++) {
			set.add(b.get(i));
		}
		int n = a.length();
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			for (String st : set) {

				if (i - st.length() + 1 >= 0 && a.substring(i - st.length() + 1, i + 1).equals(st)
						&& (i - st.length() + 1 == 0 ? true : dp[i - st.length()] == 1)) {
					dp[i] = 1;
					break;
				}

			}
		}
		return dp[n - 1];
	}

	public int wordBreak1(String a, ArrayList<String> b) {
		if (b.size() == 0) {
			return 0;
		}
		if (a.length() == 0) {
			return 1;
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < b.size(); i++) {
			set.add(b.get(i));
		}
		int n = a.length();
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = -1; j < i; j++) {

				if ((j == -1 || dp[j] == 1) && set.contains(a.substring(j + 1, i + 1))) {
					dp[i] = 1;
					break;
				}
			}
		}
		return dp[n - 1];
	}

	public int wordBreak3(String s, ArrayList<String> b) {

		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < b.size(); i++) {
			set.add(b.get(i));
		}
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j + i < n; j++) {
				// x = j
				// y = i+j
				if (set.contains(s.substring(j, j + i + 1))) {
					dp[j][i + j] = 1;
				} else {
					for (int k = j; k < j + i; k++) {
						if (dp[j][k] == 1 && dp[k + 1][i + j] == 1) {
							dp[j][j + i] = 1;
							break;
						}
					}
				}
			}

		}

		return dp[0][n - 1];

	}

}
