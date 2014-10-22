import java.util.*;
import java.io.*;

class VMGOLD {
	public static void main(String[] args) throws IOException {
		Init(is);
		solve();
	}

	static void solve() throws IOException {
		Long[] divisors = new Long[(int) (6 * 1e5)];
		int n = NextInt();
		int k = NextInt();
		int index = 0;
		for (int i = 0; i < n; ++i) {
			long a = NextLong();
			int max = (int) Math.sqrt(a);
			for (int j = 1; j <= max; ++j) {
				if (a % j == 0) {
					divisors[index++] = (long) j;
					if (j * j != a)
						divisors[index++] = (a / j);
				}
			}
		}
		Arrays.sort(divisors, 0, index);
		for (int i = index - 1; i >= 0; --i) {
			long div = divisors[i];
			long cur = 0;
			int cnt = 1;
			while (i > 0 && (cur = divisors[i - 1]) == div) {
				cnt++;
				i--;
			}
			if (cnt >= k) {
				System.out.println(divisors[i]);
				return;
			}
		}
	}

	/******************************************************************
	 ****************************** READER*****************************
	 ******************************************************************/
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static InputStream is = System.in;

	static void Init(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {

		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {

		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {

		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {

		return Double.parseDouble(Next());
	}
}

