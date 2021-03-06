import java.util.Scanner;

public class Main {

	static long count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		solve(k, m, n, k);
		System.out.println(count);
		count = 0;
	}

	private static void solve(int k, int j, int n, int max) {
		if (j == 1) {
			if (n <= k) {
				count++;
			}
			return;
		}

		if (n == 0) {
			count++;
			return;
		}
		if (n < 0 || j == 0) {
			return;
		}
		long min = (n + j - 1) / j;
		int z = n < max ? n : max;
		for (; z >= min; --z) {
			solve(k, j - 1, n - z, z);
		}

	}
}
