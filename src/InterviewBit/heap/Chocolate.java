package InterviewBit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Chocolate {
	public static void main(String[] args) {
		Chocolate chocolate = new Chocolate();
		System.out.println(chocolate.nchoc(3, new ArrayList<Integer>(Arrays.asList(5, 6))));
	}

	public int nchoc(int a, ArrayList<Integer> b) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (Integer i : b) {
			pq.add(i);
		}
		long sol = 0;
		int top;
		while (a > 0) {
			top = pq.poll();
			pq.add(top / 2);
			sol = sol + top;
			a--;
		}
		return (int) (sol % 1000000007);
	}
}
