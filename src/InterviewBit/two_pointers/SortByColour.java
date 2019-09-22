package InterviewBit.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColour {
	public static void main(String[] args) {
		SortByColour sortByColour = new SortByColour();
		sortByColour.sortColors(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 0, 1, 2)));
	}

	public void sortColors(ArrayList<Integer> a) {

		int i = 0;
		int j = 0;
		int l, r;
		int temp;
		while (i < a.size() && a.get(i) != 0) {
			i++;
		}

		if (i == a.size()) {
			l = 0;
			r = a.size() - 1;
		} else {
			while (i < a.size()) {
				if (a.get(i) == 0) {
					temp = a.get(j);
					a.set(j, 0);
					a.set(i, temp);
					j++;
				}
				i++;
			}
			l = j;
			r = a.size() - 1;
		}

		while (l < r) {
			while (a.get(l) != 2) {
				l++;
			}
			while (a.get(r) != 1) {
				r--;
			}
			if (l >= r) {
				break;
			}
			a.set(l, 1);
			a.set(r, 2);
		}
		for (Integer integer : a) {
			System.out.println(integer);
		}
	}
}
