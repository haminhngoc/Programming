import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplicationTable {

	public static void main(String[] args) throws IOException {
		MultiplicationTable main = new MultiplicationTable();
		main.solve();
	}

	void solve() throws IOException {
		ReaderMultiplicationTable reader = new ReaderMultiplicationTable();
		reader.Init(System.in);
		long n = reader.NextLong();
		long m = reader.NextLong();
		long k = reader.NextLong();
		BinarySearch(n, m, k);
	}

	void BinarySearch(long n, long m, long k) {
		long low = 0;
		long high = n * m;
		long ith = 0;
		long middle = 0;
		if (k == 1 || k == m * n) {
			System.out.print(k);
			return;
		}
		while (high > low) {
			middle = (low + high) / 2;
			ith = 0;
			for (long i = 1; i <= n; i++) {
				ith += (middle / i) > m ? m : (middle / i);
			}
			if (ith < k) {
				low = middle + 1;
			}
			else{
				high = middle ;
			}
		}
		System.out.print(low);

	}
}

class ReaderMultiplicationTable {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
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