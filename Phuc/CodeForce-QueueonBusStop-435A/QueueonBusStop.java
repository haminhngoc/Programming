import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueueonBusStop {

	public static void main(String[] args) throws IOException {
		ReaderQueueonBusStop reader = new ReaderQueueonBusStop();
		reader.Init(System.in);
		int n = reader.nextInt(); // 100
		int m = reader.nextInt(); // 100
		long sum = 0;
		long count = 0;
		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp = reader.nextInt();
			if (sum + temp > m) {
				count++;
				sum = temp;
			} else if (sum + temp == m) {
				count++;
				sum = 0;
			} else

			{
				sum += temp;
			}
		}
		if (sum > 0) {
			count++;
		}
		System.out.println(count);
	}
}

class ReaderQueueonBusStop {
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