import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/* Just curious why someone's code is long or run slowly?
 */

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		VOSSEVEN solver = new VOSSEVEN();
		solver.solve(1, in, out);
		out.close();
	}
}

/*
 * Complexity: O(n) why?
 * Run MainTest to generate large testcase (1M)
 */
class VOSSEVEN {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		char[] s = in.next().toCharArray();
		int length = s.length;
		int[] counts = new int[length + 1];

		int count7 = 0;
		for (int i = 0; i <= length; i++) {
			if (i < length && s[i] == '7') {
				count7++;
			} else {
				if (count7 > 0) {
					for (int j = 1; j <= count7; j++) {
						counts[j] += (count7 + 1 - j);
					}
				}
				count7 = 0;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int j = 1; j <= length; j++) {
			if (counts[j] > 0) {
				result.append(j + " " + counts[j] + "\r\n");
			}
		}

		out.write(result.toString());
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

}