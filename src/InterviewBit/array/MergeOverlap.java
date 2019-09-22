package InterviewBit.array;

import java.util.ArrayList;

public class MergeOverlap {
	public static void main(String[] args) {
		MergeOverlap overlap = new MergeOverlap();
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 18));
		System.out.println(overlap.merge(list));

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList<Interval> sol = new ArrayList<Interval>();
		if (intervals.size() > 0)
			sol.add(intervals.get(0));
		for (int j = 1; j < intervals.size(); j++) {
			for (int k = 0; k < sol.size();) {
				int flow = findFlow(intervals.get(j), sol.get(k));
				if (flow == -1) {
					sol.add(intervals.get(j));

				} else if (flow == 1) {
					k++;
				} else {
					intervals.get(j).start = Math.min(intervals.get(j).start, sol.get(k).start);
					intervals.get(j).end = Math.max(intervals.get(j).end, sol.get(k).end);
				}
			}
		}

		return sol;

	}

	private int findFlow(Interval node, Interval i) {
		Interval x = node;
		Interval y = i;
		if (y.start > x.end) {
			return -1;
		}
		if (y.end < x.start) {
			return 1;
		}
		return 0;
	}
}
