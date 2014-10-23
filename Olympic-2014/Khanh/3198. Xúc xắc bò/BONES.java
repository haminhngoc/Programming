import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BONES {

	public static void main(String[] args) {
		InputReader3198 in = new InputReader3198(System.in);
		int S1 = in.nextInt();
		int S2 = in.nextInt();
		int S3 = in.nextInt();
		int n = S1 + S2 + S3;
		int arr[] = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			arr[i] = 0;
		for (int i = 1; i <= S1; i++)
			for (int j = 1; j <= S2; j++)
				for (int k = 1; k <= S3; k++)
					arr[i + j + k]++;
		int cMax = arr[3];
		int result = 3;
		for (int i = 3; i < n + 1; i++)
			if (cMax < arr[i]) {
				cMax = arr[i];
				result = i;
			}
		System.out.println(result);
	}

}

class InputReader3198 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader3198(InputStream stream) {
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