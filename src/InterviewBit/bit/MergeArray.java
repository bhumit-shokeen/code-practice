package InterviewBit.bit;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeArray {
	public static void main(String[] args) {
		MergeArray mergeArray = new MergeArray();
		mergeArray.merge(new ArrayList<Integer>(Arrays.asList(1, 5, 8, 11)),
				new ArrayList<Integer>(Arrays.asList(6, 9)));
	}

	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

		int i = 0;
		int j = 0;
		for (j = 0; j < b.size() && i < a.size();) {
			if (b.get(j) < a.get(i)) {
				a.add(i, b.get(j));
				j++;
			}
			i++;
		}
		while (j < b.size()) {
			a.add(b.get(j));
			j++;
		}

		for (i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
}
