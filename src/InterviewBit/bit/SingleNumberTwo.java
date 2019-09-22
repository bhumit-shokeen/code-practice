package InterviewBit.bit;

import java.util.Arrays;
import java.util.List;

public class SingleNumberTwo {

	public static void main(String[] args) {
		SingleNumberTwo singleNumberTwo = new SingleNumberTwo();
		System.out.println(singleNumberTwo.singleNumber(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)));
	}

	public int singleNumber(final List<Integer> a) {
		long ans = 0;
		long A = 0;
		long B = 0;
		int counter = 0;
		int target;
		while (counter < 32) {
			A = 0;
			B = 0;
			for (int i = 0; i < a.size(); i++) {
				target = a.get(i) >> counter;
				if (target > 0) {
					if ((target & 1) == 1) {
						A++;
					} else
						B++;

				} else {
					B++;
				}
			}
			if (A % 3 == 1) {
				ans += Math.pow(2, counter);
			}
			counter++;
		}
		return (int) (ans);
	}

}
