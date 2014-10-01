import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long s = in.nextInt();
		long a[] = new long[n + 1];
		a[0] = 1;
		int i = 0;
		for (i = 1; i <= n; ++i) {
			long t = in.nextLong();
			a[i] = a[i - 1] * t;
			if (a[i] > 1000000000) {
				break;
			}
		}

		if (i > n) {
			i--;
		}
		long count = 0;
		while (s > 0) {
			count += s / a[i];
			s = s % a[i];
			i--;
		}
		System.out.println(count);

	}
}