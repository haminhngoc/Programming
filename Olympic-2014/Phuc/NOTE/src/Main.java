import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int f = in.nextInt();
		long p = in.nextLong();
		while (f != 0 || p != 0) {
			long z = (long) (Math.pow(2, f));

			while (p % 2 == 0) {
				f--;
				p /= 2;
			}
			long o = (long) (Math.pow(2, f - 1));
			p = (p + 1) / 2;
			long m = o + 1 - p;
			System.out.println(m % 2 == 0 ? "U" : "D");
			f = in.nextInt();
			p = in.nextLong();

		}

	}
}