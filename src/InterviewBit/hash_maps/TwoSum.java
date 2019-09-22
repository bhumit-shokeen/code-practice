package InterviewBit.hash_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		for (Integer inner : twoSum.twoSum(new ArrayList<Integer>(Arrays.asList(2, 4, 4, 4)), 8)) {
			System.out.println(inner);
		}
	}

	public ArrayList<Integer> twoSum(final ArrayList<Integer> a, int b) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> sol = new ArrayList<Integer>();

		for (int i = 0; i < a.size(); i++) {
			if (map.containsKey(b - a.get(i))) {
				sol.add(map.get(b - a.get(i)));
				sol.add(i + 1);
				break;
			} else if (!map.containsKey(a.get(i))) {
				map.put(a.get(i), i + 1);
			}

		}
		return sol;
	}

}
