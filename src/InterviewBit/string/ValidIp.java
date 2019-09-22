package InterviewBit.string;

import java.util.ArrayList;

public class ValidIp {
	public static void main(String[] args) {
		ValidIp valid = new ValidIp();

		System.out.println(valid.restoreIpAddresses("0100100"));
	}

	public ArrayList<String> restoreIpAddresses(String a) {

		String temp = "";
		ArrayList<String> sol = new ArrayList<String>();

		find(temp, sol, 1, 0, a);

		return sol;

	}

	private void find(String temp, ArrayList<String> sol, int p, int index, String a) {
		// System.out.println(temp);
		if (index >= a.length()) {
			return;
		}
		if (p == 4) {
			if (a.charAt(index) == '0') {
				if (index == a.length() - 1) {
					sol.add(temp + "0");
				}
				find(temp + "0.", sol, p + 1, index + 1, a);
			} else {

				int val = Integer.parseInt(a.substring(index));
				if (256 > val) {
					if (!sol.contains(temp + val))
						sol.add(temp + val);
				}
			}
		} else {
			if (a.charAt(index) == '0') {
				find(temp + "0.", sol, p + 1, index + 1, a);
			} else {
				for (int i = 1; i <= 4 && index + i <= a.length(); i++) {
					int val = Integer.parseInt(a.substring(index, index + i));
					if (256 > val) {
						find(temp + val + ".", sol, p + 1, index + i, a);
					}
				}
			}
		}

	}

}
