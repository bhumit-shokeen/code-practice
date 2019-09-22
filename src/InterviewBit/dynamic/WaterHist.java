package InterviewBit.dynamic;

public class WaterHist {
	public static void main(String[] args) {
		WaterHist waterHist = new WaterHist();
		System.out.println(waterHist.trap(new int[] { 4, 2, 3 }));
	}

	public int trap(int[] height) {
		int n = height.length;

		int lw = 0;
		int tw = 0;
		int rw = n - 1;
		int w = 0;

		for (int i = 1; i < n; i++) {
			if (height[i] < height[lw]) {
				tw = tw + height[lw] - height[i];
			} else {
				w = w + tw;
				tw = 0;
				lw = i;
			}
		}
		tw = 0;
		for (int i = n - 2; i >= lw; i--) {
			if (height[i] < height[rw]) {
				tw = tw + height[rw] - height[i];
			} else {
				w = w + tw;
				tw = 0;
				rw = i;
			}

		}

		return w;

	}
}
