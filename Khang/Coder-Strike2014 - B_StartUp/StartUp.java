import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class StartUp {

	private static final int[] REFLECTION = new int[] { 0, 7, 8, 12, 14, 19,
			20, 21, 22, 23, 24 };

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader reader = new InputReader(inputStream);
		int[] label = new int[26];
		for (int i = 0; i < REFLECTION.length; i++) {
			label[REFLECTION[i]] = 1;
		}
		char[] letters = reader.next().toCharArray();
		int first = 0;
		int last = letters.length - 1;
		while (last >= 0) {	
			if (letters[last] == letters[first]
					&& label[-65 + (int) letters[last]] == 1) {			
				last--;
				first++;
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
