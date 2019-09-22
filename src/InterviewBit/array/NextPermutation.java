package InterviewBit.array;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation nextPermutation = new NextPermutation();
		// nextPermutation.nextPermutation(new ArrayList<>(Arrays.asList(59,
		// 854, 422)));
		nextPermutation.nextPermutation(new ArrayList<>(Arrays.asList(701, 319, 695, 52)));

	}

	public void nextPermutation(ArrayList<Integer> a) {
		// int i = 3;
		int temp;
		int n = a.size();
		if (n == 1)
			return;

		if (a.get(n - 2) < a.get(n - 1) || n == 2) {
			temp = a.get(n - 1);
			a.set(n - 1, a.get(n - 2));
			a.set(n - 2, temp);
		} else {
			for (int i = 3; i <= a.size(); i++) {
				if (next(a, n - i, n - 1)) {
					break;
				}
			}
		}

		for (Integer integer : a) {
			System.out.print(" " + integer);
		}
	}

	private boolean next(ArrayList<Integer> a, int s, int e) {
		if (s < 0) {
			// swap logic as pattern is highest
			int temp;
			for (int i = 0; i < (e + 1) / 2; i++) {
				temp = a.get(i);
				a.set(i, a.get(e - i));
				a.set(e - i, temp);
			}
			return true;

		} else {
			int diff = Integer.MAX_VALUE;
			int index = -1;
			int temp;
			for (int i = s + 1; i <= e; i++) {
				temp = a.get(i) - a.get(s);
				if (temp < diff && temp > 0) {
					diff = temp;
					index = i;
				}
			}
			if (index == -1) {
				return false;
			} else {
				// swap s and index + put the rest array on reverse order
				temp = a.get(s);
				a.set(s, a.get(index));
				a.set(index, temp);
				for (int i = 0; i < (e - s) / 2; i++) {
					temp = a.get(s + 1 + i);
					a.set(s + 1 + i, a.get(e - i));
					a.set(e - i, temp);

				}

			}
			return true;
		}
	}

	public void nextPermutation1(ArrayList<Integer> a) {
		int i;
		int temp;
		int n = a.size();
		for (i = n - 1; i >= 0; i--) {
			if (i > 0) {
				if (a.get(i - 1) < a.get(i)) {
					temp = a.get(i);
					a.set(i, a.get(i - 1));
					a.set(i - 1, temp);
					break;
				} else {
					temp = a.get(i);
					a.set(i, a.get(i - 1));
					a.set(i - 1, temp);

				}
			} else {
				for (int j = 1; j <= (n - 1) / 2; j++) {
					temp = a.get(j);
					a.set(j, a.get(n - j));
					a.set(n - j, temp);
				}

			}

		}

		for (Integer integer : a) {
			System.out.print(" " + integer);
		}
	}
	// 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199
	// 201 788 609 582 979 259 901 371 766 759 983 728 220 16 158 822 515 488
	// 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734
	// 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165
	// 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856
	// 701 319 695 52
	// 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199
	// 201 788 609 582 979 259 901 371 766 759 983 728 220 52 16 158 822 515 488
	// 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734
	// 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165
	// 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856
	// 701 319 695
	// 444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199
	// 201 788 609 582 979 259 901 371 766 759 983 728 220 16 158 822 515 488
	// 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734
	// 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165
	// 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856
	// 701 695 52 319
}
