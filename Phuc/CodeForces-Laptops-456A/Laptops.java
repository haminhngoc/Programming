import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Laptops {

	public static void main(String[] args) throws IOException {
solve();
	}

	static void solve() throws IOException {
		Init(System.in);
		int n = nextInt();
		List<Laptop> list = new ArrayList<Laptop>();
		Laptop temp;
		boolean result = true;
		for (int i = 0; i < n; ++i) {
			temp = new Laptop();
			temp.a = nextInt();
			temp.b = nextInt();
			if (temp.a != temp.b) {
				result = false;
			}
		}
		System.out.println(!result ? "Happy Alex" : "Poor Alex");

	}

	static class Laptop {
		int a;
		int b;
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
