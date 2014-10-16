import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class VOSEXPTEST {

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 2*10^7
		long A = sc.nextLong(); // 10^12
		long a = sc.nextLong(); // 10^5
		long b = sc.nextLong(); // 10^5
		long c = sc.nextLong(); // 10^5
		long d = sc.nextLong(); // 10^12
		long BASE = sc.nextLong(); // 10^9

		long T = a; // <= 10^12 < 2^41
		long F = 0;
		A = A % BASE;
		for (int i = 1; i <= M; i++) {
			F = (F + powerBaseInt(A, T, BASE)) % BASE;
			T = (T * b + c) % d;
		}
		System.out.println(F);
	}

	static long powerBaseInt(long X, long p, long BASE) {

		if (p == 0) {
			return 1;
		}

		if (p == 1) {
			return X % BASE;
		}

		long result = powerBaseInt(X, p >> 1, BASE);
		result = (result * result) % BASE;

		if ((p & 0x1) == 1) {
			result = (result * X) % BASE;
		}
		return result;
	}
}

/*
 * Some other ideas has been commented: Some of them can be used in other
 * problem For e.g If BASE, A, N <= 10^12, How to calculate A^N % BASE?
 * 
 * static long M2 = 0x100000; static long FM2 = 0xfffff; static int
 * powerBase(long A, long p, long BASE) { if (p < cacheSize) { return
 * powerCache[(int) p]; }
 * 
 * long result = powerBase(A, p >> 1, BASE); result = (result * result) % BASE;
 * 
 * if ((p & 0x1) == 1) { result = (result * A) % BASE; } return (int) result; }
 * 
 * // X <= 10^9 static long powerBaseInt(long X, long p, long BASE) { if (p ==
 * 1) { return X; }
 * 
 * long result = powerBaseInt(X, p >> 1, BASE); result = (result * result) %
 * BASE;
 * 
 * if ((p & 0x1) == 1) { result = (result * X) % BASE; } return result; }
 * 
 * // X, BASE <= 10^12 static long powerBaseLong(long X, long p, long BASE) { if
 * (p == 1) { return X; }
 * 
 * long result = powerBaseLong(X, p >> 1, BASE); result =
 * multiplyBaseLong(result, result, BASE);
 * 
 * if ((p & 0x1) == 1) { result = multiplyBaseLong(result, X, BASE); } return
 * result; }
 * 
 * // X, Y, BASE <= 10^12 static long multiplyBaseLong(long X, long Y, long
 * BASE) { long b1 = X >> 20; long b2 = X & FM2; // X = b1 * M2 + b2; // return
 * ((((M2 * Y) % BASE) * b1) % BASE + (b2 * Y) % BASE) % BASE; return (((M2 * Y)
 * % BASE) * b1 + b2 * Y) % BASE; // Will be OK too, why? }
 */