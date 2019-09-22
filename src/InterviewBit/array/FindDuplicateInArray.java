package InterviewBit.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInArray {
	public static void main(String[] args) {
		FindDuplicateInArray duplicateInArray = new FindDuplicateInArray();
		System.out.println(duplicateInArray.repeatedNumber(Arrays.asList(3, 4, 1, 4, 1)));
	}

	public int repeatedNumber(final List<Integer> a) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (Integer value : a) {
			if (!hashMap.containsKey(value)) {
				hashMap.put(value, 1);
			} else {
				return value;
			}
		}

		return -1;
	}

}
