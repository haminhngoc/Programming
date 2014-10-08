import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TanCungSo0_2942 solver = new TanCungSo0_2942();
		solver.solve(1, in, out);
		out.close();
	}
}

class TanCungSo0_2942 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[] letters = new int[26];
        char[] s = in.next().toCharArray();
        for (int i = 0; i < s.length; i++) {
            letters[s[i] - 'a']++;
        }
        int numerator = 0;
        int denominator = 0;
        numerator = countZero(s.length);
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                denominator += countZero(letters[i]);
            }
        }
        out.println(numerator - denominator);
    }

    static int countZero(int n) {
        int out = 0;
        for (int k = 0; Math.pow(5, k + 1) < n; k++) {
            out += (int) (n / Math.pow(5, k+1));
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

}

