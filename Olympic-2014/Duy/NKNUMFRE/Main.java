import java.util.*;
import java.io.*;

class NKNUMFRE {
	public static void main(String[] args) throws IOException {
		Init(is);
		solve();
	}

	static void solve() throws IOException {
		int from = NextInt();
		int to = NextInt();
		int ans = 0;
		for (int cur = from; cur <= to; ++cur) {
			int x = cur;
			StringBuilder tmp = new StringBuilder();
			tmp.append(cur);
			int y = Integer.parseInt(tmp.reverse().toString());
			if (gcd(x, y) == 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static int gcd(int x, int y) {
		if (x == 0) {
			return y;
		}
		while (y != 0) {
			if (x > y) {
				x -= y;
			} else {
				y -= x;
			}
		}
		return x;
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

