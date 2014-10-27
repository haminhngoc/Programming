import java.util.Scanner;

public class Main {
	static int lock1[] = new int[3];
	static int lock2[] = new int[3];
	static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();

		for (int i = 0; i < 3; ++i) {
			lock1[i] = in.nextInt();
		}

		for (int i = 0; i < 3; ++i) {
			lock2[i] = in.nextInt();
		}
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				for (int k = 1; k <= n; ++k) {
					boolean c1 = check1(i, j, k);
					boolean c2 = check2(i, j, k);
					if (c1 || c2) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	static boolean check(int k, int q) {
		if (k + 1 == q || k + 2 == q || k == q || k - 1 == q || k - 2 == q
				|| k + 2 == q + n || k + 1 == q + n || k + n - 2 == q
				|| k + n - 1 == q) {
			return true;
		}
		return false;
	}

	private static boolean check1(int i, int j, int k) {

		if (check(i, lock1[0]) && check(j, lock1[1]) && check(k, lock1[2]))
			return true;
		return false;
	}

	private static boolean check2(int i, int j, int k) {
		if (check(i, lock2[0]) && check(j, lock2[1]) && check(k, lock2[2]))
			return true;
		return false;
	}
}
