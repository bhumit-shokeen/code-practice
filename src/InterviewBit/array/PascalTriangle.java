package InterviewBit.array;

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		int sol[] = pascalTriangle.getRow(4);
		for (int i = 0; i < sol.length; i++) {
			System.out.print(" " + sol[i]);
		}
	}

	public int[] getRow(int a) {
		int[] old = new int[a + 1];
		old[0] = 1;
		int[] ret = new int[a + 1];
		ret[0] = 1;

		for (int i = 1; i < a + 1; i++) {
			for (int j = 0; j <= i; j++) {
				ret[j] = back(old, j - 1, a) + old[j];

			}
			copy(old, ret);
		}
		return ret;
	}

	private void copy(int[] old, int[] ret) {
		for (int i = 0; i < ret.length; i++) {
			old[i] = ret[i];
		}

	}

	private int front(int[] old, int i, int a) {
		if (i > a) {
			return 0;
		}
		return old[i];
	}

	private int back(int[] old, int i, int a) {
		if (i < 0) {
			return 0;
		}

		return old[i];
	}
}
