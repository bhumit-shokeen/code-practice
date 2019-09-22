package InterviewBit.array;

import java.util.ArrayList;
import java.util.List;

public class Reverse {

	public static void main(String[] args) {
		Reverse reverse = new Reverse();
		System.out.println(reverse.reverse(1000));
	}

	public int reverse(int A) {
		int digit;
		long ans = 0;
		List<Integer> sol = new ArrayList<Integer>();
		if (A >= 0) {
			while (A > 0) {
				digit = A % 10;
				sol.add(digit);
				A = A / 10;
			}
			for (int i = sol.size() - 1; i >= 0; i--) {
				ans = ans + (long) (sol.get(i) * Math.pow(10, sol.size() - 1 - i));
			}
			if (ans > Math.pow(2, 31) - 1) {
				return 0;
			}
			return (int) ans;
		} else if (A == Integer.MIN_VALUE) {
			return 0;
		} else {
			A = A * -1;
			while (A > 0) {
				digit = A % 10;
				sol.add(digit);
				A = A / 10;
			}
			for (int i = sol.size() - 1; i >= 0; i--) {
				ans = ans + (long) (sol.get(i) * Math.pow(10, sol.size() - 1 - i));
			}
			if (ans > Math.pow(2, 31)) {
				return 0;
			}
			return (int) (ans) * -1;

		}
	}

}
