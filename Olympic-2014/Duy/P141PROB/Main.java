import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {

	static int[] nextX = new int[] { 1, -1, 0 };
	static int[] nextY = new int[] { 1, 0, -1 };
	static int n;
	static int m;
	static char[][] a;

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		n = in.nextInt();
		m = in.nextInt();
		a = new char[n][];

		for (int i = 0; i < n; i++) {
			a[i] = in.next().toCharArray();
		}

		int res = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 'o') {
					res += get(i, j);
				}
				if (a[i][j] == '.') {
					max = Math.max(max, getMax(i, j));
				}
			}
		}
		out.println(res + max);
	}

	private int getMax(int curX, int curY) {
		int cnt = 0;
		for (int i = 0; i < nextX.length; i++) {
			for (int j = 0; j < nextY.length; j++) {
				int x = curX + nextX[i];
				int y = curY + nextY[j];
				if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 'o') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private int get(int curX, int curY) {
		int cnt = 0;
		for (int i = 0; i < nextX.length; i++) {
			for (int j = 0; j < nextY.length; j++) {
				if ((nextX[i] == -1 && nextY[j] == 0) || nextY[j] == -1
						|| (nextX[i] == 0 && nextY[j] == 0)) {
					continue;
				}
				int x = curX + nextX[i];
				int y = curY + nextY[j];
				if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 'o') {
					cnt++;
				}

			}
		}

		return cnt;
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
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
