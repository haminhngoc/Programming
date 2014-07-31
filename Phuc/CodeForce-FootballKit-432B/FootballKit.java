import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FootballKit {

	public static void main(String[] args) throws IOException {
		ReaderFootballKit reader = new ReaderFootballKit();
		reader.Init(System.in);
		int n = reader.nextInt();
		int[] home = new int[n];
		int[] away = new int[n];
		int[] homeColor = new int[100001];
		int[] awayColor = new int[100001];

		for (int i = 0; i < n; ++i) {
			home[i] = reader.nextInt();
			homeColor[home[i]]++;
			away[i] = reader.nextInt();
			awayColor[home[i]]++;
		}
		for (int i = 0; i < n; ++i) {
			System.out.print(n - 1 + homeColor[away[i]]+" ");
			System.out.println(n - 1 - homeColor[away[i]]);
		}

	}

}

class ReaderFootballKit {
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