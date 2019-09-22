package InterviewBit.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MouseHole {
	public static void main(String[] args) {
		MouseHole mouseHole = new MouseHole();
		System.out.println(mouseHole.mice(new ArrayList<Integer>(Arrays.asList(4, -4, 2)),
				new ArrayList<Integer>(Arrays.asList(4, 0, 5))));
	}

	public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		int sol = Math.abs(a.get(0) - b.get(0));
		int temp;
		for (int i = 1; i < a.size(); i++) {
			temp = Math.abs(a.get(i) - b.get(i));
			sol = Math.max(sol, temp);
		}
		return sol;
	}
}
