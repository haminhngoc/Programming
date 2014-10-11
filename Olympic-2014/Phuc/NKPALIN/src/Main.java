import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		char s[] = next().toCharArray();
		char s1[] = reverse(s);
		System.out.println(getLCS(s, s1));
	
	}

	static char[] reverse(char s[]) {
		int length = s.length;
		char s1[] = new char[length];
		for (int i = 0; i < length; ++i) {
			s1[i] = s[length - i - 1];
		}

		return s1;
	}
	public static char[] getLCS(char[] x, char[] y) {
		int m = x.length;
		int n = y.length;
		int[][] lcs = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x[i] == y[j]) {
					lcs[i + 1][j + 1] = lcs[i][j] + 1;
				} else {
					lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
				}
			}
		}
		int cnt = lcs[m][n];
		char[] res = new char[cnt];
		for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
			if (x[i] == y[j]) {
				res[--cnt] = x[i];
				--i;
				--j;
			} else if (lcs[i + 1][j] > lcs[i][j + 1]) {
				--j;
			} else {
				--i;
			}
		}
		return res;
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

class P {
	int index = 0;
	StringBuilder s;

	public P() {
		index = -1;
		s = new StringBuilder();
	}
}
