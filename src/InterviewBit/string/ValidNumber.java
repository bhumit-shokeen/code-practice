package InterviewBit.string;

public class ValidNumber {
	public static void main(String[] args) {
		ValidNumber validNumber = new ValidNumber();
		System.out.println(validNumber.isNumber("-3.e10"));
	}

	public int isNumber(final String a) {
		String input = a.trim();
		if (input.matches("^-*\\d+")) {
			return 1;
		} else if (input.matches("^-*\\d*\\.\\d+")) {
			return 1;
		} else if (input.matches("^-*\\d+e-*\\d+")) {
			return 1;
		} else if (input.matches("^-*(\\d*\\.\\d+){1,}e-*\\d+")) {
			return 1;
		}
		return 0;
	}
}
