import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long x = 0;
		in.nextLine();
		for (int i = 0; i < n; ++i) {
			String s = in.nextLine();
			if (s.charAt(1) == '+') {
				x++;
			} else {
				x--;
			}
		}
		System.out.println(x);

	}

	

}