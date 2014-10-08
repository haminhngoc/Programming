import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class VMGOLD_20650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader20650 in = new InputReader20650(inputStream);

		Integer n = in.nextInt();
		int k = in.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextLong();
		long r = Check(arr, n, k);
		System.out.println(r);
	}

	private static long Check(long[] arr, int n, int k) {
		// TODO Auto-generated method stub
		long max = 0;
		for (int i = 0; i < n; i++)
			if (max < arr[i])
				max = arr[i];
		long x = max;
		while (x > 1) {
			int result = 0;
			int i = n - 1;
			while (i > 0) {
				if (arr[i] % x == 0)
					result++;
				if (result >= k)
					return x;
				i--;
			}
			if (arr[0] % x == 0)
				result++;
			if (result >= k)
				return x;
			x--;
		}
		return 1;
	}
}

class InputReader20650 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader20650(InputStream stream) {
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

	public long nextLong() {
		return Long.parseLong(next());
	}

}