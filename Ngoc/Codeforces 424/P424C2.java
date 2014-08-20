import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P424C2 {

	public static void main(String[] args) throws IOException {
		initReader();
		int n = nextInt(); // 10^6

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum ^= nextInt();
		}

		int len2 = n / 2 + 1;
		int[] acc = new int[len2 + 1];
		int cur = 0;
		for (int i = 2; i < len2; i++) {
			cur ^= (i - 1);
			acc[i] = cur;

			sum ^= acc[n % i + 1];
			if (((n / i) & 0x01) == 0) {
				sum ^= cur;
			}
		}
		if ((n & 0x01) == 1) {
			cur ^= len2 - 1;
			len2++;
		}
		for (int i = len2; i <= n; i++) {
			cur ^= (i - 1);
			sum ^= cur;
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
