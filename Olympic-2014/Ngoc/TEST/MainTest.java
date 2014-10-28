import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.InputStream;

public class MainTest {
	public static void main(String[] args) {

		initReader();

		Random rand = new Random();
		int A9 = 1000000000;
		if (true) {
			// For C11LOCK
			int n = 500;
			System.out.println(n + " " + (A9 + 2 * rand.nextInt(A9)));
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print((A9 + 2 * rand.nextInt(A9)) + " ");
				}
				System.out.println();
			}
		}

		if (false) {
			// For KVIP
			int n = 1000;
			System.out.println(n);
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(rand.nextInt(1000000000) + " ");
				}
				System.out.println("");
			}
		}

		if (false) {
			// For NKREZ
			int MAX = 30000;
			int n = 50000;

			System.out.println(n);

			for (int i = 0; i < n; i++) {
				int start = rand.nextInt(MAX / 2);
				int end = start + rand.nextInt(MAX - start);

				System.out.println(start + " " + end + " ");
			}
		}

		if (false) {
			// For VOSSEVEN
			int n = 1000000;

			StringBuilder text = new StringBuilder();
			for (int i = 0; i < n; i++) {
				text.append(rand.nextInt(10));
			}

			System.out.println(text.toString());
		}
	}

	/*
	 * *****************************************************************
	 * ******************* BASIC READER ******************************* ***************************************************************
	 */

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

	static String nextLine() throws IOException {
		return reader.readLine();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

}
