import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Crash {

	public static void main(String[] args) throws IOException {
		ReaderCrash reader = new ReaderCrash();
		reader.Init(System.in);
		int n = reader.nextInt(); // 10^5
		boolean result = true;
		int[] status = new int[100000 + 1];
		for (int i = 0; i <= 100000; ++i) {
			status[i] = -1;
		}
		int x;
		int y;
		for (int i = 0; i < n; ++i) {
			x = reader.nextInt();
			y = reader.nextInt();
			if (status[y] <x - 1 &&x>=status[y]) {
				result = false;
			}else if(status[y]==x-1)
			{
				status[y]=x;
			}
		}

		System.out.println(result ? "YES" : "NO");

	}

}

class ReaderCrash {
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