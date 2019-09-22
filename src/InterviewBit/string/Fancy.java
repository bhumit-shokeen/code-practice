package InterviewBit.string;

import java.util.HashMap;

public class Fancy {
	public static void main(String[] args) {
		Fancy fancy = new Fancy();
		System.out.println(fancy.isFancy("110"));
		System.out.println(fancy.isFancy("121"));
		System.out.println(fancy.isFancy("121"));
		System.out.println(fancy.isFancy("121"));

	}

	public String isFancy(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		char[] a = s.toCharArray();
		int n = a.length;
		int mid = n / 2;

		int i = 0;
		boolean isEven = n % 2 == 0;
		while (mid + i < n) {
			if (!isEven && (!map.containsKey(a[mid - i]) || a[mid + i] != map.get(a[mid - i]))) {
				return "no";
			}
			if (isEven && (!map.containsKey(a[mid - i - 1]) || a[mid] != map.get(a[mid - i - 1]))) {
				return "no";
			}
			i++;
		}
		return "yes";

	}

}
