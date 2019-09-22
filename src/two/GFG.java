/*
  http://practice.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation/0
 Given a sorted integer array of size N, and 3 integers A, B and C. The task is to find and print a new array in sorted order(increasing) where
                                                                        Ainew=A*Aiold*Aiold+B*Aiold+C

Input:
The first line of input contains T denoting the number of test cases.The first line of each test case contains three integers A, B, and C, as described above. The second line of each test case contains a single integer N, the size of the input array. The third line of each test case contains N-space separated integers, denoting the array.

Output:
For each test case output, a single line containing N-space separated integers, the elements of the new array in sorted order.

Constraints:
1<= T <= 1000
-105<= A,B,C <= 105
1<=N<=102
-105<= Ai <= 105

Example:
Input:

1
-1 2 -1
6
-1 0 1 2 3 4
Output:
-9 -4 -4 -1 -1 0

Explanation:
After sorting, we get {-9, -4, -4, -1, -1, 0}
After applying the equation A*x*x + B*x + C on every element x we get, {-4,-1, 0, -1, -4, -9}
Input array is {-1, 0, 1, 2, 3, 4}.
 */
package two;

import java.util.Arrays;
import java.util.Scanner;

class GFG {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int counter = 0; counter < in.nextInt(); counter++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int n = in.nextInt();
			int[] ar = new int[n];
			int no = 0;

			for (int i = 0; i < n; i++) {
				no = in.nextInt();
				// System.out.print(in.nextInt());
				// System.out.print(n);

				ar[i] = (a * no * no) + (b * no) + (c);

			}
			int[] temp = sortedArray(new int[] { 4, 3, 2, 1, 0 });
			Arrays.sort(ar);
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i] + " ");

			}

		}

	}

	public static int findMin(int[] ar) {
		int min = ar[0];
		int minIndex = 0;
		for (int i = 1; i < ar.length; i++) {
			if (min > ar[i]) {
				min = ar[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static int[] sortedArray(int[] ar) {
		int minIndex = findMin(ar);
		if (minIndex == 0) {
			return ar;
		}
		int ds1 = 0;
		int dl1 = minIndex;
		int is2 = minIndex + 1;
		int il2 = ar.length - 1;
		int k = 0;
		int[] temp = new int[ar.length];

		for (int i = 0; !(dl1 < ds1 || is2 > il2); i++) {
			if (ar[dl1] > ar[is2]) {
				temp[k] = ar[is2];
				is2++;
				k++;
			} else {
				temp[k] = ar[dl1];
				dl1--;
				k++;
			}

		}
		while (is2 <= il2) {
			temp[k] = ar[is2];
			is2++;
			k++;
		}
		while (dl1 >= ds1) {
			temp[k] = ar[dl1];
			dl1--;
			k++;
		}

		return temp;

	}
}