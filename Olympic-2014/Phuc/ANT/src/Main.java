import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();

		System.out.println(J(m, n));

	}

	static long J2(long m, long n) {
		long D = 1;
		while (D <= (m - 1) * n)
			D = D * m / (m - 1);
		return m * n + 1 - D;
	}

	static long J(long m, long n) {
		if (n == 1)
			return 1;
		if (n <= m)
			return (J(m, n - 1) + m - 1) % n + 1;
		long K = J(m, n - n / m);
		if (K <= n % m)
			return K + n - n % m;
		long L = K - n % m;
		return L + (L - 1) / (m - 1);
	}
}
