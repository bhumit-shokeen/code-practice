package string;

public class JsonPrettifier {

	public static void main(String[] args) {
		JsonPrettifier jsonPrettifier = new JsonPrettifier();
		jsonPrettifier.jsonClean("{“group” : {list : [1,2,3]}, “list” : [“a”,”b”,”c”]}");
	}

	public void jsonClean(String input) {
		int openBacket = 0;
		boolean arrayMode = false;
		char target;
		for (int i = 0; i < input.length(); i++) {
			target = input.charAt(i);
			if (target == '{') {

				System.out.format("%c \n%s ", target, generateWideSpace(openBacket));
				openBacket++;

			} else if (target == '}') {
				openBacket--;
				System.out.format("\n%s%c", generateWideSpace(openBacket), target);
			} else if (target == '[') {
				arrayMode = true;
				System.out.format("%c", target);
			} else if (target == ']') {
				arrayMode = false;
				System.out.format("%c", target);
			} else if (target == ',') {
				if (arrayMode) {
					System.out.format("%c", target);
				} else
					System.out.format("%c\n%s", target, generateWideSpace(openBacket));

			} else
				System.out.format("%c", target);
		}

	}

	String generateWideSpace(int openBacket) {
		String space = "";
		for (int i = 0; i < openBacket; i++) {
			space = space + "  ";
		}
		return space;
	}
}
