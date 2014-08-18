import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long m = in.nextInt();
		long k = in.nextLong();
		if (k == 1) {
			
			System.out.println(1);
		} else if (k == n*m) {
			System.out.println(n * m);
		} else {
			System.out.println(search(0, n * m, n, m, k));
		}
	}

	private static long search(long left, long right, long n, long m, long k) {

		long count = 0;
		while (left != right) {
			long mid = (left + right) / 2;
			count = 0;
			for (int i = 1; i <= n; ++i) {
				count += Math.min(m, mid / i);
			}
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}
		return left;
	}

}
