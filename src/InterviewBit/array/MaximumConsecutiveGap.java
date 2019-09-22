package InterviewBit.array;

public class MaximumConsecutiveGap {

	public static void main(String[] args) {
		MaximumConsecutiveGap consecutiveGap = new MaximumConsecutiveGap();
		System.out.println(consecutiveGap.maximumGap(new int[] { 30, 1, 10, 15 }));
	}

	class Bucket {
		int min;
		int max;

		Bucket() {
			min = -1;
			max = -1;
		}
	}

	public int maximumGap(final int[] a) {
		if (a.length < 2) {
			return 0;
		}
		int min = a[0];
		int max = a[0];
		for (Integer value : a) {
			if (value < min) {
				min = value;
			}
			if (value > max) {
				max = value;
			}

		}
		Bucket[] buckets = new Bucket[a.length + 1];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}
		double gap = (double) (a.length) / (max - min);
		int index;
		for (Integer value : a) {
			index = (int) ((value - min) * gap);
			if (buckets[index].min == -1) {
				buckets[index].min = value;
				buckets[index].max = value;
			} else {
				buckets[index].min = Integer.min(buckets[index].min, value);
				buckets[index].max = Integer.max(buckets[index].max, value);

			}
		}
		int sol = Integer.MIN_VALUE;
		int pre = buckets[0].max;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].min != -1) {

				if (buckets[i].min - pre > sol) {
					sol = buckets[i].min - pre;
				}
				pre = buckets[i].max;
			}
		}
		return sol;

	}

}
