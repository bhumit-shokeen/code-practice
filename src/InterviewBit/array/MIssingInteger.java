package InterviewBit.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MIssingInteger {
	public static void main(String[] args) {
		MIssingInteger mIssingInteger = new MIssingInteger();
		System.out.println(mIssingInteger.firstMissingPositive(new ArrayList<Integer>(Arrays.asList(1, 3, 2))));
		System.out.println(mIssingInteger.firstMissingPositive(new ArrayList<Integer>(Arrays.asList(1, 2, 0))));
	}

	public int firstMissingPositive(ArrayList<Integer> a) {
		boolean hasZero = false;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < 0) {
				a.set(i, 0);
			}
			if (a.get(i) == 0) {
				hasZero = true;
			}
		}
		int current;

		for (int i = 0; i < a.size(); i++) {
			current = a.get(i);
			// ignore negative numbers && index is less than the size of the
			// array && ! (current is negative && )
			// if (current != 0 && current < a.size() && !(current < 0 &&
			// current == a.get(Math.abs(current)))) {
			if (current != 0 && Math.abs(current) < a.size() && !(a.get(Math.abs(current)) < 0)) {
				if (a.get(Math.abs(current)) == 0) {
					a.set(Math.abs(current), Math.abs(current) * -1);
				} else {
					a.set(Math.abs(current), a.get(Math.abs(current)) * -1);
				}
			}

		}
		int sol = 0;
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) >= 0) {
				sol = i;
				break;
			}
			if (i == a.size() - 1 && sol == 0) {
				return a.size() + (hasZero ? 0 : 1);
			}
		}
		if (sol == 0) {
			if (a.get(0) == 1) {
				return 2;
			} else {
				return 1;
			}
		}
		return sol;
	}
}
