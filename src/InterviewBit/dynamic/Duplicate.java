package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Duplicate {
	public static void main(String[] args) {
		// myCode code = new myCode();
		// System.out.println(code.findDuplicateCount("aa"));
		Duplicate code = new Duplicate();
		// System.out.println(code.maxProduct("1,2,3,4,5"));
		System.out.println(code.insertComma(""));
	}

	private String insertComma(String input) {
		if (input.isEmpty()) {
			return "";
		}
		String[] ip = input.split("\\.");
		ArrayList<Character> number = new ArrayList<Character>();
		StringBuffer buffer = new StringBuffer();
		int counter = 0;
		if (ip[0].charAt(0) == '-') {
			counter = 0;
			for (int i = ip[0].length() - 1; i > 0; i--) {
				if (counter == 3) {
					number.add(0, ',');
					counter = 0;
				}
				number.add(0, ip[0].charAt(i));
				counter++;
			}
			buffer.append("-");
			for (int i = 0; i < number.size(); i++) {
				buffer.append(number.get(i));
			}
		} else {
			counter = 0;
			for (int i = ip[0].length() - 1; i >= 0; i--) {
				if (counter == 3) {
					number.add(0, ',');
					counter = 0;
				}
				number.add(0, ip[0].charAt(i));
				counter++;

			}
			for (int i = 0; i < number.size(); i++) {
				buffer.append(number.get(i));
			}
		}
		String sol = buffer.toString();
		if (ip.length > 1 && ip[1].length() != 0) {
			sol = sol + "." + ip[1];
		}

		return sol;
	}

	private long maxProduct(String input) {
		if (input.isEmpty()) {
			return -1;
		}
		String[] ip = input.split("\\s*,\\s*");
		int n = ip.length;
		if (n < 3) {
			return -1;
		}
		long[] newArray = new long[n];
		for (int i = 0; i < n; i++) {
			newArray[i] = Long.valueOf(ip[i]);
		}
		Arrays.sort(newArray);
		long sol1 = newArray[n - 1] * newArray[n - 2] * newArray[n - 3];
		long sol2 = newArray[n - 1] * newArray[0] * newArray[1];
		return Long.max(sol1, sol2);
	}

	private int findDuplicateCount(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 0);
			}
		}
		int sol = 0;
		for (Character key : map.keySet()) {
			sol += map.get(key);
		}
		return sol;
	}

}
