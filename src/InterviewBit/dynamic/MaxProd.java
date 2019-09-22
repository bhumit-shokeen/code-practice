package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class MaxProd {
	public static void main(String[] args) {
		MaxProd maxProd = new MaxProd();
		System.out.println(maxProd.maxProduct(Arrays.asList(2, -2, -2)));
	}

	public int maxProduct(final List<Integer> a) {
		int p = 0;
		int n = 0;
		int pMax = 0;
		int no = 0;
		int pOld = 0;
		for (int i = 0; i < a.size(); i++) {
			no = a.get(i);
			if (no > 0) {
				if (p == 0) {
					p = no;
				} else {
					p = p * no;
				}
				n = n * no;
			} else if (no < 0) {
				pOld = p;
				p = n * no;
				n = Math.min(pOld * no, no);

			} else {
				p = 0;
				n = 0;
			}
			pMax = Math.max(pMax, p);
		}
		return pMax;
	}
}
