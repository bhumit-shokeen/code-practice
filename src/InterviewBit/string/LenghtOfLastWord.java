package InterviewBit.string;

public class LenghtOfLastWord {
	public static void main(String[] args) {
		LenghtOfLastWord lenghtOfLastWord = new LenghtOfLastWord();
		System.out.println(lenghtOfLastWord.lengthOfLastWord("ddf"));
	}

	public int lengthOfLastWord(final String a) {
		int len = 0;
		int lastNonZero = 0;
		char current;
		for (int i = 0; i < a.length(); i++) {
			current = a.charAt(i);
			if (current == ' ') {
				if (len != 0) {
					lastNonZero = len;
				}
				len = 0;
			} else
				len++;
		}

		return len == 0 ? lastNonZero : len;
	}
}
