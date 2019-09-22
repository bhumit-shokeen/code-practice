package InterviewBit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxPair {
	public static void main(String[] args) {
		MaxPair maxPair = new MaxPair();
		for (Integer val : maxPair.solve(new ArrayList<Integer>(Arrays.asList(1, 4, 2, 3)),
				new ArrayList<Integer>(Arrays.asList(2, 5, 1, 6)))) {
			System.out.println(val);
		}
	}

	public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
		a.sort(Collections.reverseOrder());
		b.sort(Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = a.size();
		int s;
		for (Integer i : a) {
			for (Integer j : b) {
				s = i + j;
				if (pq.size() < n) {
					pq.add(s);
				} else {
					if (s > pq.peek()) {
						pq.poll();
						pq.add(s);
					} else {
						break;
					}
				}
			}

		}
		ArrayList<Integer> sol = new ArrayList<Integer>(pq);
		sol.sort(Collections.reverseOrder());
		return sol;
	}
}
