import java.util.*;

public class JzzhuAndSequences {
	private static final long CONST = 1000000007;

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		long x = reader.nextLong(); // 10^9
		long y = reader.nextLong(); // 10^9
		long n = reader.nextLong(); // 10^9
		if (n == 1) {
			System.out.println(Mod(x, CONST));
		} else if (n == 2) {
			System.out.println(Mod(y, CONST));
		} else {
			long z = y - x;
			long tmp = 1;
			if (n % 3 == 1) {
				if (n % 2 == 0)
					tmp = -1;
				System.out.println(Mod(x * tmp, CONST));
			} else if (n % 3 == 2) {
				if (n % 2 != 0)
					tmp = -1;
				System.out.println(Mod(y * tmp, CONST));
			} else {
				if (n % 2 == 0)
					tmp = -1;
				System.out.println(Mod(z * tmp, CONST));
			}
		}

	}

	private static long Mod(long a, long b) {
		long result = a % b;
		if (result < 0)
			result += b;
		return result;
	}

}
