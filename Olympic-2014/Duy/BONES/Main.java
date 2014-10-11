import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inStream = System.in;
		OutputStream outStream = System.out;
		InputReader in = new InputReader(inStream);
		PrintWriter out = new PrintWriter(outStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

}

class Task {
	public void solve(InputReader in, PrintWriter out) {
		int s1 = in.nextInt();
		int s2 = in.nextInt();
		int s3 = in.nextInt();
		int[] sum = new int[s1 + s2 + s3 + 1];
		for (int i = 1; i <= s1; i++) {
			for (int j = 1; j <= s2; j++) {
				for (int k = 1; k <= s3; k++) {
					sum[i + j + k]++;
				}
			}
		}
		int max = 0;
		int res = 0;
		for (int i = 0; i <= s1 + s2 + s3; i++) {
			if (max < sum[i]) {
				max = sum[i];
				res = i;
			}
		}
		out.println(res);
	}
}

class InputReader {
	static BufferedReader reader;
	static StringTokenizer token;

	public InputReader(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in), 32768);
		token = null;
	}

	public String nextLine() {
		String out = null;
		try {
			out = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public String next() {
		while (token == null || !token.hasMoreTokens()) {
			token = new StringTokenizer(nextLine());
		}
		return token.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}

