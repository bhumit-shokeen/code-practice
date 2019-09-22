package InterviewBit.dynamic;

import java.util.ArrayList;

public class UglyNumbers {
	public static void main(String[] args) {
		UglyNumbers uglyNumbers = new UglyNumbers();
		System.out.println(uglyNumbers.solve(3, 11, 7, 50));

	}

	public ArrayList<Integer> solve(int a, int b, int c, int d) {
		ArrayList<Integer> dp = new ArrayList<Integer>();
		int i1, i2, i3;
		i1 = i2 = i3 = -1;
		int nI1, nI2, nI3;
		nI1 = a;
		nI2 = b;
		nI3 = c;
		int min;
		for (int i = 0; i < d; i++) {
			min = Math.min(nI1, Math.min(nI2, nI3));
			dp.add(min);
			if (min == nI1) {
				nI1 = a * dp.get(++i1);
			}
			if (min == nI2) {
				nI2 = b * dp.get(++i2);
			}
			if (min == nI3) {
				nI3 = c * dp.get(++i3);
			}
		}

		return dp;
	}

}
