package InterviewBit.bit;

import java.util.ArrayList;
import java.util.Arrays;

public class PairWise {
	public static void main(String[] args) {
		PairWise pairWise = new PairWise();
		System.out.println(pairWise.cntBits(new ArrayList<Integer>(Arrays.asList(1, 3, 5))));
	}

	public int cntBits(ArrayList<Integer> a) {
		long ans = 0;
		long A = 0;
		long B = 0;
		int counter = 32;
		int target;
		while (counter > 0) {
			A = 0;
			B = 0;
			for (int i = 0; i < a.size(); i++) {
				target = a.get(i);
				if (target > 0) {
					if ((target & 1) == 1) {
						A++;
					} else
						B++;
					a.set(i, target >> 1);

				} else {
					B++;
				}
			}
			ans += 2L * A * B;
			counter--;
		}
		return (int) (ans % 1000000007);
	}
}
