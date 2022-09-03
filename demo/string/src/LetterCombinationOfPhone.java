import java.util.Scanner;

public class LetterCombinationOfPhone {
	static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//String phone = sc.nextLine();
		printSequence("232342", "", 0);
	}

	public static void printSequence(String phone, String str, int start) {
		if (str.length() == phone.length()) {
			System.out.println(str);
			return;
		}
		String word = map[phone.charAt(start) - '0'];
		for (int i = 0; i < word.length(); i++) {
			printSequence(phone, str + word.charAt(i), start + 1);
		}
	}
}
