import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			str.append(i);
		}

		System.out.println(str.indexOf(n + "") + 1);
	}

}
