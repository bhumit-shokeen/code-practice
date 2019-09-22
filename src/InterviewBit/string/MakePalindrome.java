package InterviewBit.string;

public class MakePalindrome {
	public static void main(String[] args) {
		MakePalindrome makePalindrome = new MakePalindrome();
		System.out.println(makePalindrome.solve("abc"));
	}

	public int solve(String a) {
		int sol = 0;
		for (int i = 0; i < a.length(); i++) {
			if (isPalindrome(a, 0, a.length() - 1 - sol)) {
				break;
			}
			sol++;
		}

		return sol;
	}

	boolean isPalindrome(String a, int s, int e) {
		boolean sol = true;
		while (e > s) {
			if (a.charAt(s) != a.charAt(e)) {
				sol = false;
				break;
			}
			s++;
			e--;
		}

		return sol;

	}
}
