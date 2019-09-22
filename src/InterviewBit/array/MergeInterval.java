package InterviewBit.array;

import java.util.ArrayList;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeInterval {

	public static void main(String[] intervals) {
		MergeInterval mergeInterval = new MergeInterval();
		ArrayList<Interval> intervals1 = mergeInterval.insert(null, new Interval(1, 2));
		intervals1 = mergeInterval.insert(intervals1, new Interval(3, 5));
		intervals1 = mergeInterval.insert(intervals1, new Interval(6, 7));
		intervals1 = mergeInterval.insert(intervals1, new Interval(8, 10));
		intervals1 = mergeInterval.insert(intervals1, new Interval(12, 16));
		intervals1 = mergeInterval.insert(intervals1, new Interval(4, 9));

		for (int i = 0; i < intervals1.size(); i++) {
			System.out.println(intervals1.get(i).start + " " + intervals1.get(i).end);
		}

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty()) {
			list.add(newInterval);
			return list;
		}
		Interval small = null;
		Interval large = null;
		int i = 0;
		while (intervals.size() > i || newInterval != null) {
			if (intervals.get(i).start < newInterval.start) {
				small = intervals.get(i);
				large = newInterval;
				if (small.end < large.start) {
					// intervals.remove(0);
					// list.add(small);
					i++;
				} else {
					intervals.remove(i);
					newInterval = merge(small, large);
				}
			} else {
				small = newInterval;
				large = intervals.get(i);
				if (small.end < large.start) {
					newInterval = null;
					// list.add(small);
					intervals.add(i, small);
					i++;
				} else {
					intervals.remove(i);
					newInterval = merge(small, large);
				}
			}

			if (newInterval == null) {
				i = intervals.size();
			} else if (intervals.size() <= i && newInterval != null) {
				// list.add(newInterval);
				intervals.add(i, newInterval);
				i++;
				newInterval = null;
			}
		}
		return intervals;
	}

	private Interval merge(Interval small, Interval large) {
		Interval retInterval = new Interval();
		if (small.end < large.end) {
			retInterval.start = small.start;
			retInterval.end = large.end;
			return retInterval;
		}
		return small;
	}
}
