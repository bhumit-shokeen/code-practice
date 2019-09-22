package InterviewBit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LengthK {

	public static void main(String[] args) {
		LengthK lengthK = new LengthK();
		System.out.println(lengthK.solve(new ArrayList<>(Arrays.asList(2, 9)), 5, 17015));
	}

	public int solve(ArrayList<Integer> A, int B, int C) {
		if (A.isEmpty()) {
			return 0;
		}
		List<Integer> hash = new ArrayList<Integer>();
		int temp = C;
		int len = 0;
		int sol = 0;
		int j = 0;
		while (temp > 0) {
			hash.add(temp % 10);
			temp /= 10;
			len++;
		}
		Collections.reverse(hash);
		if (B > len) {
			return 0;
		} else if (B < len) {
			if (hash.get(0) == 0) {
				return (int) ((A.size() - 1) * Math.pow(A.size(), B - 1));
			} else {
				return (int) (Math.pow(A.size(), B));
			}
		} else {
			for (int i = 0; i < hash.size(); i++) {
				for (j = 0; j < A.size() && A.get(j) < hash.get(i); j++) {
					if (A.get(j) != 0 || i != 0) {
						sol += Math.pow(A.size(), B - 1 - i);
					}
				}
				if (j == A.size() || j == 0) {
					if (B == 1 && A.get(0) == 0) {
						sol++;
					}
					return sol;
				}
			}

		}
		if (B == 1 && A.get(0) == 0) {
			sol++;
		}
		return sol;
	}
}
