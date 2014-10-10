import java.io.*;
import java.util.*;

class CBUYING {
	public static void main(String[] args) throws IOException {
		Init(is);
		input();
		solve();
	}

	static void solve() {
		Arrays.sort(p);
		long res = 0;
		for (int i = 0; i < n; i++) {
			long canBuy = Math.min(p[i].nCow, b / p[i].cost);
			if (canBuy == 0) {
				break;
			}
			res += canBuy;
			b -= canBuy * p[i].cost;
		}
		System.out.println(res);
	}

	/******************************************************************
	 ****************************** INPUT *****************************
	 ******************************************************************/
	static int n;
	static long b;
	static chocolate[] p;

	static void input() throws IOException {
		n = NextInt();
		b = NextLong();
		p = new chocolate[n];
		for (int i = 0; i < n; i++) {
			chocolate c = new chocolate();
			c.cost = NextLong();
			c.nCow = NextLong();
			p[i] = c;

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

class chocolate implements Comparable<chocolate> {
	long cost;
	long nCow;

	public int compareTo(chocolate c) {
		long comp = this.cost - c.cost;
		return (int) comp;
	}
}
