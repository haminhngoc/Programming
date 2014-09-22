import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PaintingFence {
	public static void main(String[] args) throws IOException {
		ReaderPaintingFence reader = new ReaderPaintingFence();
		reader.Init(System.in);
		int n = reader.nextInt();
		int[] value = new int[n];
		for (int i = 0; i < n; ++i) {
			value[i] = reader.nextInt();
		}
		System.out.println(dfs(0, n-1, value));
	}

	private static int dfs(int left, int right, int[] value) {
		if(right<left){
			return 0;
		}
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int i = left; i <= right; ++i) {
			if (value[i] < min) {
				min = value[i];
			}
		}
		result += min;

		for (int i = left; i <= right; ++i) {
			value[i] -= min;
		}
		int temp = left;
		for (int i = left; i <= right; ++i) {
			if (value[i] == 0) {
				if (temp!=i) {
					result += dfs(temp, i-1, value);
					
				}
				temp = i + 1;
			}
		}
		if(right>temp){
			result += dfs(temp, right, value);
		}
		if(right==temp){
			result += 1;
		}

		return Math.min(result, right - left + 1);
	}

}
class ReaderPaintingFence {
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

