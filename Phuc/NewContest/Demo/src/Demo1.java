import java.awt.Checkbox;
import java.awt.font.NumericShaper;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String inputString = in.next();

		int nunberCharacters = in.nextInt();
	
		int length = inputString.length();
		int number = (length + nunberCharacters) / 2;
		char[] inputArr = inputString.toCharArray();
		while (!Check(inputArr, number, nunberCharacters, length)) {
			number--;
		}
		System.out.println(2 * number);
		
		
	}

	public static Boolean Check(char[] input, int number, int numberOfUnaddd,
			int length) {
		int start = 0;
		int total = length + numberOfUnaddd;
		while (start + 2 * number <= total) {
			int end = start + number - 1;
			int i =0;
			for (i = start; i <= end; ++i) {
				if (i + number >= length) {
					return true;
				} else if (input[i] != input[i + number]) {
					break;
				}
			}
			if(i>end){
				return true;
			}
			start++;
		}

		return false;
	}
}
