import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class NOIXICH {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		Integer N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; ++i)
			arr[i] = in.nextInt();

		Arrays.sort(arr);
		int remains = N - 1;
		int x = 0;
		int time = 0;
		while (remains > arr[x] + 1) {
			remains -= (arr[x] + 1);
			time += arr[x];
			x++;
		}
		time += remains;
		System.out.println(time);
	}

}

class InputReader {
	BufferedReader reader;
	StringTokenizer tokenizer;

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