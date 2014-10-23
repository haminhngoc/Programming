import java.util.*;
import java.io.*;

class VRATF {
	public static void main(String[] args) throws IOException {
		Init(is);
		solve();
	}

	static long res = 1;

	static void solve() throws IOException {
		int n = NextInt();
		int k = NextInt();
		recur(n, k);
		System.out.println(res);
	}

	private static void recur(int n, int k) {
		int tmp = (n + k);
		int div = tmp >> 1;
		int mod = (tmp & 1);
		if (mod == 0 && div < n) {
			res--;
			int x = div;
			int y = n - x;
			recur(x, k);
			recur(y, k);
			res += 2;
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

