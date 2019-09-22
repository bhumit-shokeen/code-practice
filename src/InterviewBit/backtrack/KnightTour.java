package InterviewBit.backtrack;

public class KnightTour {
	public static void main(String[] args) {
		KnightTour kt = new KnightTour();

		int sol[][] = kt.moves(0, 0, 8, 8);
		for (int i = 0; i < sol.length; i++) {
			System.out.println("");
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(" " + sol[i][j]);
			}
		}
	}

	int[] x = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	int[] y = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

	private int[][] moves(int i, int j, int n, int m) {
		// TODO Auto-generated method stub
		return null;
	}

}
