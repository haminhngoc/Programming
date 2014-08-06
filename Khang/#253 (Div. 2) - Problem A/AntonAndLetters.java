import java.util.Arrays;
import java.util.Scanner;

public class AntonAndLetters {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		int nDistinctLetter = 0;
		String setOfLetters = reader.nextLine();
		for (int i = 0; i < setOfLetters.length(); i++) {
			if (setOfLetters.charAt(i) != ' ' 
					&& setOfLetters.charAt(i) != '{'
					&& setOfLetters.charAt(i) != '}'
					&& setOfLetters.charAt(i) != ',') {
				if (setOfLetters.indexOf(setOfLetters.charAt(i)) == i) {
					nDistinctLetter++;
				}
			}
		}
		System.out.println(nDistinctLetter);
	}

}
