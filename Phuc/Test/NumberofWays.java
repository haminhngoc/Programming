import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberofWays {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		long a[] = new long[n + 1];
		for (int i = 1; i <= n; ++i) {
			long t = nextLong();
			a[i] = a[i - 1] + t;
		}
		if (a[n] % 3 != 0) {
			System.out.println(0);
			return;
		}
		long s = a[n] / 3;
		int count1[] = new int[n + 1];
		int count2[] = new int[n + 2];
		
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			if (a[i] == s) {
				count++;
				count1[i] = count;
			}
		}
		count = 0;
		for (int i = n; i >= 1; --i) {
			if (a[i] - a[i - 1] == s) {
				count++;
				count2[i] = count;
			}
		}
		long r = 0;
		for (int i = n; i >= 1; --i) {
			if(a[i]==s){
				
			}
		}
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
