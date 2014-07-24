import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class DZYLovesHash {

	public static void main(String[] args) throws IOException {
		DZYLovesHash main = new DZYLovesHash();
		main.solve();

	}

	void solve() throws IOException {
		Reader5 reader = new Reader5();
		reader.Init(System.in);
		int p = reader.NextInt();
		int n = reader.NextInt();
		Vector inputs = new Vector();
		int[] buckets = new int[p];
		for (int i = 0; i < p; i++) {
			buckets[i] = 0;
		}
		int temp = 0;
		int h = 0;
		for (int i = 0; i < n; i++) {
			temp = reader.NextInt();
			h = temp % p;
			if (buckets[h] == 1) {
				System.out.print(i + 1);
				return;
			} else {
				buckets[h] = 1;
			}
		}
		System.out.print(-1);
	}

}

class Reader5 {
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