import java.util.Arrays;
import java.util.Scanner;

public class DZYLovesStrings {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		String str = reader.nextLine();
		int result = 0;
		int nInputLetter = reader.nextInt();
		int[] alphabetValues = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabetValues[i] = reader.nextInt();
		}

		for (int i = 0; i < str.length(); i++) {
			int temp = (int) str.charAt(i);
			int temp_integer = 96;
			if (temp <= 122 & temp >= 97) {				
				result += alphabetValues[temp - temp_integer - 1] * (i + 1);
			}
		}
		Arrays.sort(alphabetValues);
		for (int i = str.length(); i < str.length() + nInputLetter; i++) {
			result += alphabetValues[alphabetValues.length - 1] * (i + 1);			
		}
		System.out.println(result);
	}

}
