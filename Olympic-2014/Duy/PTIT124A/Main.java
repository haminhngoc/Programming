import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;

class PTIT124G {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		solve();
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in), 32768);

	static void solve() throws NumberFormatException, IOException {

		int n = Integer.parseInt(reader.readLine());
		String[] pattern = getPattern();
		for (int id = 1; id <= n; id++) {
			String[] line = reader.readLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			char[] s = parseString(line);
			int max = r * c;
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length; i++) {
				if (s[i] == ' ') {
					sb.append(pattern[0]);
				} else {
					sb.append(pattern[1 + s[i] - 'A']);
				}
			}
			String res = "";
			if (sb.length() >= max) {
				res = sb.substring(0, max);
			} else {
				while (sb.length() < max) {
					sb.append(0);
				}
				res = sb.toString();
			}
			System.out.println(id + " " + buildSpirit(res, r, c));
		}
	}

	private static String buildSpirit(String res, int n, int m) {
		char[][] a = new char[n][m];
		boolean[][] label = new boolean[n][m];
		int i = 0;
		int j = 0;
		a[0][0] = res.charAt(0);
		int index = 1;
		label[0][0] = true;
		int cnt = 1;
		while (cnt < n * m) {
			while (j + 1 < m && !label[i][j + 1]) {
				label[i][j + 1] = true;
				a[i][j + 1] = res.charAt(index++);
				cnt++;
				j++;
			}
			while (i + 1 < n && !label[i + 1][j]) {
				label[i + 1][j] = true;
				a[i + 1][j] = res.charAt(index++);
				cnt++;
				i++;
			}

			while (j - 1 >= 0 && !label[i][j - 1]) {
				label[i][j - 1] = true;
				a[i][j - 1] = res.charAt(index++);
				cnt++;
				j--;
			}
			while (i - 1 >= 0 && !label[i - 1][j]) {
				label[i - 1][j] = true;
				a[i - 1][j] = res.charAt(index++);
				cnt++;
				i--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < n; k++) {
			sb.append(new String(a[k]));
		}
		return sb.toString();
	}

	private static String[] getPattern() {
		String[] s = new String[27];
		for (int i = 0; i <= 26; i++) {
			s[i] = convertHexToBi(i);
		}
		return s;
	}

	private static String convertHexToBi(int i) {
		StringBuilder sb = new StringBuilder();
		while (i / 2 != 0) {
			sb.append(i % 2);
			i /= 2;
		}
		if (i == 1) {
			sb.append(1);
		}
		while (sb.length() < 5) {
			sb.append(0);
		}

		sb.reverse();
		return sb.toString();
	}

	private static char[] parseString(String[] line) {
		if (line.length == 2) {
			return " ".toCharArray();
		}
		int n = line.length - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n; i++) {
			sb.append(line[i] + " ");
		}
		sb.append(line[n]);
		return sb.toString().toCharArray();
	}
}

