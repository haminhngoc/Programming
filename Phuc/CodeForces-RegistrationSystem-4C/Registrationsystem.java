import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Registrationsystem {
	public static void main(String[] args) throws IOException {
		Init(System.in);
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int n = nextInt();
		Integer value;
		String temp;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			temp = next();
			value = hash.get(temp);
			if (value != null) {
				result.append(temp + value + "\n");
				hash.put(temp, value + 1);
			} else {
				result.append("OK\n");
				hash.put(temp, 1);
			}
		}
		System.out.print(result);
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
