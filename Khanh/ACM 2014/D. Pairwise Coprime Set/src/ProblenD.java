import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblenD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			int N = in.nextInt();
			System.out.println("Case #" + iT + ": " + findPair(N));
		}
	}

	private static int findPair(int n) {
		// TODO Auto-generated method stub
		boolean[] arr = new boolean[n + 1];
		for (int i = 1; i < n + 1; ++i)
			arr[i] = true;

		for (int i = 2; i < n + 1; ++i)
			if (arr[i] == true)
				for (int j = i * 2; j < n + 1; j += i)
					arr[j] = false;

		int count = 0;
		for (int i = 1; i < n + 1; ++i)
			if (arr[i] == true)
				count++;

		return count;
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