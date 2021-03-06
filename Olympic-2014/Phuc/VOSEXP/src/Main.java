import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		
		int M = nextInt();
		long A = nextLong();
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();
		long d = nextLong();
		int BASE = nextInt();

		A %= BASE;

		long arr[] = new long[1000001];
		long temp[] = new long[1000001];

		arr[0] = 1;
		temp[0] = 1;

		for (int i = 1; i <= 1000000; ++i) {
			arr[i] = (arr[i - 1] * A) % BASE;
			temp[i] = (temp[i - 1] * A) % BASE;
			temp[i] *= arr[i - 1];
			temp[i] %= BASE;
			temp[i] *= arr[i - 1];
			temp[i] %= BASE;
		}
		
		
		long r = arr[a];
		long t = a;
		for (int i = 2; i <= M; ++i) {
			t = (t * b + c) % d;
			long z = (int) Math.sqrt(t);

			int e = (int) (t - z * z);
			long k = 1;
			k *= temp[(int)z];
			k %= BASE;
			k *= arr[e / 2];
			k %= BASE;
			k *= arr[e / 2];
			k %= BASE;
			if (e % 2 == 1) {
				k *= A;
				k %= BASE;
			}
			r += k;
			r %= BASE;

		}

		System.out.println(r);

	}

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
