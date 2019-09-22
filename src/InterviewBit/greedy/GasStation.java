package InterviewBit.greedy;

import java.util.Arrays;
import java.util.List;

public class GasStation {
	public static void main(String[] args) {
		GasStation gas = new GasStation();
		System.out.println(gas.canCompleteCircuit(Arrays.asList(684, 57, 602, 987), Arrays.asList(909, 535, 190, 976)));
	}

	public int canCompleteCircuit(final List<Integer> g, final List<Integer> c) {
		int currSum = 0;
		int n = g.size();
		for (int i = 0; i < n; i++) {
			currSum = g.get(i) - c.get(i);
			for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
				if (currSum < 0) {
					break;
				}
				currSum += g.get(j) - c.get(j);
				if (currSum < 0) {
					if (i > j) {
						return -1;
					}
					i = j;
					break;
				}
			}
			if (currSum >= 0) {
				return i;
			}
		}
		return -1;
	}
}
