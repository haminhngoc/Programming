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

	public static String findLongestPalindrome() throws IOException {
		String s = next();
		if (s == null || s.length() == 0)
			return "";

		char[] s2 = addBoundaries(s.toCharArray());
		int[] p = new int[s2.length];
		int c = 0, r = 0; // Here the first element in s2 has been processed.
		int m = 0, n = 0; // The walking indices to compare if two elements are
							// the same
		for (int i = 1; i < s2.length; i++) {
			if (i > r) {
				p[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int i2 = c * 2 - i;
				if (p[i2] < (r - i)) {
					p[i] = p[i2];
					m = -1; // This signals bypassing the while loop below.
				} else {
					p[i] = r - i;
					n = r + 1;
					m = i * 2 - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				p[i]++;
				m--;
				n++;
			}
			if ((i + p[i]) > r) {
				c = i;
				r = i + p[i];
			}
		}
		int len = 0;
		c = 0;
		for (int i = 1; i < s2.length; i++) {
			if (len < p[i]) {
				len = p[i];
				c = i;
			}
		}
		char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
		return String.valueOf(removeBoundaries(ss));
	}

	private static char[] addBoundaries(char[] cs) {
		if (cs == null || cs.length == 0)
			return "||".toCharArray();

		char[] cs2 = new char[cs.length * 2 + 1];
		for (int i = 0; i < (cs2.length - 1); i = i + 2) {
			cs2[i] = '|';
			cs2[i + 1] = cs[i / 2];
		}
		cs2[cs2.length - 1] = '|';
		return cs2;
	}

	private static char[] removeBoundaries(char[] cs) {
		if (cs == null || cs.length < 3)
			return "".toCharArray();

		char[] cs2 = new char[(cs.length - 1) / 2];
		for (int i = 0; i < cs2.length; i++) {
			cs2[i] = cs[i * 2 + 1];
		}
		return cs2;
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
		for (int i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
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
