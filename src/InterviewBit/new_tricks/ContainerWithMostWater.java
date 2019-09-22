package InterviewBit.new_tricks;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea(new ArrayList<Integer>(Arrays.asList(1, 5, 4, 3))));

	}

	public int maxArea(ArrayList<Integer> a) {
		int l = 0;
		int r = a.size() - 1;
		int maxArea = Integer.MIN_VALUE;
		int area;
		while (l < r) {
			area = (r - l) * (Integer.min(a.get(l), a.get(r)));
			if (maxArea < area) {
				maxArea = area;

			}
			if (a.get(l) < a.get(r)) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}
}
