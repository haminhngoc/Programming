import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class COUNTCBG {
	public static void main(String[] args) {
		solve();
	}

	static void solve() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			System.out.println(count(n));
		}
	}

	private static int count(int n) {
		int cnt = 0;
		int tmp = n / 2;
		int tmp1 = n - tmp;
		if (Math.abs(tmp - tmp1) == 1) {
			cnt++;
		}
		int max = (int) Math.sqrt(n);
		for (int i = 2; i <= max; i++) {
			if (n % i == 0) {
				if ((i & 1) == 1) {
					cnt++;
				}
				if (i * i != n) {
					if (((n / i) & 1) == 1) {
						cnt++;
					}
				}

			}
		}
		return cnt;
	}
}

