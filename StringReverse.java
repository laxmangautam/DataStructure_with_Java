public class StringReverse {

	public static void main(String[] args) {

		String name = "I am here";

		System.out.println(reverse(name));

	}

	public static String reverse(String str) {
		char[] charArray = str.toCharArray();

		int j = str.length() - 1;
		for (int i = 0; i < (str.length() / 2); i++) {
			char tempChar = charArray[j];
			charArray[j] = charArray[i];
			charArray[i] = tempChar;
			j--;

		}

		return new String(charArray);
	}

}
