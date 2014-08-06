import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FootballKit {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader reader = new InputReader(inputStream);
		int n = reader.nextInt(); // 10^5
		int[] awayKits = new int[n];
		int[] label = new int[(int) 1e6];		
		int nGame = 2 * (n - 1);
		for (int i = 0; i < n; i++) {
			label[reader.nextInt()]++;	
			awayKits[i] = reader.nextInt();					
		}
		for (int i = 0; i < n; i++) {
			System.out.println(nGame / 2 + label[awayKits[i]] + " "
					+ (nGame - (nGame / 2 + label[awayKits[i]])));
		}
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