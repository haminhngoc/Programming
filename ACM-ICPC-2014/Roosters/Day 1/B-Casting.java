import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int P = in.nextInt();
		while (P > 0) {
			int t = in.nextInt();
			int B = in.nextInt();
			String s = in.next();

			solve(t, B, s);
			P--;
		}
	}

	private static void solve(int t, int b, String s) {
		System.out.print(t + " ");
		if (b == 2) {
			System.out.println(0);
			return;
		}

		int l = s.length();
		int remain = 0;
		for (int i = 0; i < l; ++i) {
			remain += s.charAt(i) - '0';
			remain %= (b - 1);
		}
		System.out.println(remain);
	}
}
