import java.util.Arrays;
import java.util.Scanner;

public class DZYLovesChessboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r, c;
		r = sc.nextInt();
		c = sc.nextInt();

		String in = new String();
		in = sc.nextLine();
		boolean rowPosition = false;
		for (int i = 0; i < r; i++) {
			in = sc.nextLine();
			Solve(in, rowPosition);
			rowPosition = !rowPosition;

		}
		sc.close();
	}

	private static void Solve(String in, boolean rowPosition) {
		String result = new String();
		char odd = rowPosition == true ? 'B' : 'W';
		char even = rowPosition == false ? 'B' : 'W';
		int length = in.length();
		char c;
		for (int i = 0; i < length; i++) {
			c = in.charAt(i);
			if (c == '.') {
				if (i % 2 == 1) {
					result += odd;
				} else if (i % 2 == 0) {
					result += even;
				}
			} else {
				result += in.charAt(i);
			}
		}
		System.out.println(result);
	}

}
