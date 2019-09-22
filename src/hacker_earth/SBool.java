package hacker_earth;

class SBool {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if (b1 & b2 | b2 & b3 | b2) /* Line 9 */
			System.out.print("ok ");
		if (b1 & b2 | b2 & b3 | b2 | b1) /* Line 11 */
			System.out.println("yes");
	}
}
