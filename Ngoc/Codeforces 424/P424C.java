import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P424C {

	public static void main(String[] args) throws IOException {
		initReader();
		int n = nextInt(); // 10^6

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum ^= nextInt();
		}

		int[] acc = new int[n + 1];
		for (int i = 1; i < n; i++) {
			acc[i + 1] = acc[i] ^ i;
		}

		for (int i = 2; i <= n; i++) {
			int u = n / i;
			int r = n % i;
			sum ^= acc[r + 1];
			if ((u & 0x01) == 1) {
				sum ^= acc[i];
			}
		}

		System.out.println(sum);
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	public static void initReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
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
}
