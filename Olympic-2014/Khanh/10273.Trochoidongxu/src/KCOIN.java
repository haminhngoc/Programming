import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class KCOIN {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int N = in.nextInt();

		long[] arr = new long[N + 1];
		arr[0] = 0;
		for (int i = 1; i <= N; ++i)
			arr[i] = arr[i - 1] + find2in(i);

		if (N == 0)
			System.out.println(1);
		else if (N == 1)
			System.out.println(2);
		else {
			int result = 2;
			long max2 = arr[N];
			for (int K = 1; K < N; ++K)
				if (max2 <= arr[K] + arr[N - K]){
					System.out.println(K);
					result++;}
			System.out.println(result);
		}
	}

	private static int find2in(int i) {
		int r = 0;
		while (i % 2 == 0) {
			r++;
			i = i / 2;
		}
		return r;
	}
}

class InputReader {
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
}