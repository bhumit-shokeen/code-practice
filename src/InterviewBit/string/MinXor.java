package InterviewBit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXor {
	public static void main(String[] args) {
		MinXor minXor = new MinXor();
		System.out.println(minXor.findMinXor(new ArrayList<Integer>(Arrays.asList(0, 4, 7, 9))));
	}

	public int findMinXor(ArrayList<Integer> a) {
		Collections.sort(a);
		int min = Integer.MAX_VALUE;
		int temp;
		for (int i = 0; i < a.size() - 1; i++) {
			temp = a.get(i) ^ a.get(i + 1);
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}
}
