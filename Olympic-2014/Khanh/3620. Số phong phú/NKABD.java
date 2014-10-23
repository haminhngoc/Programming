import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class NKABD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader3620 in = new InputReader3620(inputStream);
		int left = in.nextInt();
		int right = in.nextInt();

		long sum[] = new long[right + 1];

		for (int i = 1; i <= right; i++)
			sum[i] = 1;
		for (int i = 2; i <= right; i++)
			for (int j = 2 * i; j <= right; j += i)
				sum[j] += i;

		int count = 0;
		for (int i = left; i <= right; i++)
			if (sum[i] > i)
				count++;

		System.out.println(count);
	}
}

class InputReader3620 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader3620(InputStream inputStream) {
		reader = new BufferedReader(new InputStreamReader(inputStream), 32768);
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

}