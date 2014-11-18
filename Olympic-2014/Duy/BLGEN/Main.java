import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;

class BLGEN {
	public static void main(String[] args) throws IOException {
		solve();
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));

	static void solve() throws IOException {
		String[] firstNu = reader.readLine().split(" ");
		String[] secondNu = reader.readLine().split(" ");
		// generatePrime((int) 1e7);
		int n1 = firstNu.length;
		int n2 = secondNu.length;
		long[] fNu = new long[n1];
		long[] sNu = new long[n2];
		int length1 = 0;
		for (int i = 0; i < n1; i++) {
			long next = Long.parseLong(firstNu[i]);
			if (check(next)) {
				fNu[length1] = next;
				length1++;
			}

		}
		int length2 = 0;
		for (int i = 0; i < n2; i++) {
			long next = Long.parseLong(secondNu[i]);
			if (check(next)) {
				sNu[length2] = next;
				length2++;
			}
		}
		int[][] maxLength = new int[length1 + 1][length2 + 1];
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (fNu[i - 1] == sNu[j - 1]) {
					maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
				} else {
					maxLength[i][j] = Math.max(maxLength[i - 1][j],
							maxLength[i][j - 1]);
				}
			}
		}
		System.out.println(maxLength[length1][length2]);
	}

	static boolean check(long x) {
		long tmp = (long) Math.ceil(Math.sqrt(x));
		long tmp1 = (long) Math.ceil(Math.pow(x, (1.0 / 3)));
		if (tmp * tmp == x || (tmp1 * tmp1 * tmp1 == x && checkPrime(tmp1))) {
			return true;
		}
		return false;
	}

	private static boolean checkPrime(long tmp1) {
		int length = (int) Math.sqrt(tmp1);
		for (int i = 2; i <= length; i++) {
			if (tmp1 % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean[] isPrimes;

	static void generatePrime(int lim) {
		isPrimes = new boolean[lim + 1];
		Arrays.fill(isPrimes, true);
		isPrimes[0] = false;
		isPrimes[1] = false;
		for (int i = 2; i * i <= lim; i++) {
			if (isPrimes[i])
				for (int j = i * i; j <= lim; j += i) {
					isPrimes[j] = false;
				}
		}
	}
	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

}

