import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		StringBuilder str = new StringBuilder();
		while (n-- > 0) {
			char s[] = next().toCharArray();
			str.append(solve(s));
			str.append("\n");
		}
		System.out.print(str);
	}

	private static long solve(char[] s) {
		int con = 'A';
		int arr[] = new int['Z' - con + 1];
		int length = s.length;
		for (int i = 0; i < length; ++i) {
			arr[s[i] - con]++;
		}
		long two = exe(length, 2);
		long five = exe(length, 5);
		for (int i = 'A'; i <= 'Z'; ++i) {
			if (arr[i - con] == 0) {
				continue;
			}
			two -= exe(arr[i - con], 2);
			five -= exe(arr[i - con], 5);
		}
		return Math.min(two, five);
	}

	private static long exe(int length, int i) {

		long re = 0;
		int k = i;
		while (length >= k) {
			re += length / k;
			k *= i;
		}
		return re;
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

/*
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TanCungSo0_2942 solver = new TanCungSo0_2942();
		int n = Integer.parseInt(in.next());
		StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			ans.append(solver.solve(i, in, out) + "\n");
		}
		out.write(ans.toString());
		out.close();
	}
}

class TanCungSo0_2942 {

	public long solve(int testNumber, InputReader in, PrintWriter out) {
		int[] letters = new int[26];
		char[] s = in.next().toCharArray();
		for (int i = 0; i < s.length; i++) {
			letters[s[i] - 'A']++;
		}
		int numerator = 0;
		int denominator = 0;
		numerator = countZero(s.length);
		for (int i = 0; i < 26; i++) {
			if (letters[i] != 0) {
				denominator += countZero(letters[i]);
			}
		}

		return (numerator - denominator);
	}

	static int countZero(int n) {
		int out = 0;
		for (int k = 0; Math.pow(5, k + 1) <= n; k++) {
			out += (int) (n / Math.pow(5, k + 1));
		}
		return out;
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
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

}*/
