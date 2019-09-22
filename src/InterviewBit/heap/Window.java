package InterviewBit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Window {
	public static void main(String[] args) {
		Window window = new Window();
		for (Integer i : window.dNums(new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3)) {
			System.out.println(i);
		}
	}

	public ArrayList<Integer> dNums(ArrayList<Integer> a, int b) {
		if (b > a.size()) {
			return new ArrayList<Integer>();
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < b; i++) {
			if (map.containsKey(a.get(i))) {
				map.put(a.get(i), map.get(a.get(i)) + 1);
			} else {
				map.put(a.get(i), 1);
			}
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		sol.add(map.size());
		for (int i = b; i < a.size(); i++) {
			// remove the front element of the window
			if (map.get(a.get(i - b)) > 1) {
				map.put(a.get(i - b), map.get(a.get(i - b)) - 1);
			} else {
				map.remove(a.get(i - b));
			}

			if (map.containsKey(a.get(i))) {
				map.put(a.get(i), map.get(a.get(i)) + 1);
			} else {
				map.put(a.get(i), 1);
			}
			sol.add(map.size());
		}

		return sol;
	}
}
