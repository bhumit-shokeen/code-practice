//https://www.geeksforgeeks.org/shortest-common-supersequence/
package dynamic;

public class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		char[] s1 = "AGGTAB".toCharArray();
		char[] s2 = "GXTXAYB".toCharArray();
		System.out.println(css(s1, s2, s1.length - 1, s2.length - 1));
	}

	private static String css(char[] s1, char[] s2, int i, int j) {
		if (i < 0 && j < 0) {
			return "";
		}
		if (i < 0) {
			String ret = "";
			for (int j2 = 0; j2 <= j; j2++) {
				ret = ret + s2[j2];
			}
			return ret;
		}
		if (j < 0) {
			String ret = "";
			for (int i2 = 0; i2 <= i; i2++) {
				ret = ret + s1[i2];
			}
			return ret;
		}

		if (s1[i] == s2[j]) {
			return (css(s1, s2, i - 1, j - 1) + s1[i]);
		} else {
			String st1 = css(s1, s2, i - 1, j) + s1[i];
			String st2 = css(s1, s2, i, j - 1) + s2[j];
			return st1.length() < st2.length() ? st1 : st2;
		}

	}
}
