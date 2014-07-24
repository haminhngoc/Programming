import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SerejaandMirroring {

	public static void main(String[] args) throws IOException {
		SerejaandMirroring main = new SerejaandMirroring();
		main.solve();
	}

	void solve() throws IOException {
		ReaderSerejaandMirroring reader = new ReaderSerejaandMirroring();
		reader.Init(System.in);
		int n = reader.NextInt();
		int m = reader.NextInt();
		int[][] inputs = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				inputs[i][j] = reader.NextInt();
			}
		}
		int res = n;
		if (n % 2 == 1) {
			System.out.print(n);
			return;
		}
		int length = n / 2;
		while (length >= 1) {	
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < m; j++) {
					if (inputs[i][j] != inputs[(2 * length-1) - i][j]) {
						System.out.print(res);
						return;
					}
				}
			}
			res = length;
			if(length % 2 ==1)
			{
				break;
			}
			length = length / 2;	
		}
		System.out.print(res);
	}

}

class ReaderSerejaandMirroring {
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