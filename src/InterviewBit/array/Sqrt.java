package InterviewBit.array;

public class Sqrt {
	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.sqrt(2));

	}

	public int sqrt(int a) {
		if (a == 0) {
			return 0;
		}
		int min = 1;
		int max = 46340;
		long sol;
		int mid = 0;
		while (min < max) {
			mid = min + (max - min) / 2;
			sol = (mid) * (mid);

			if (sol <= a && a < (mid + 1) * (mid + 1)) {
				min = mid;
				break;
			}
			if (sol < a) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

}
