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
		NKLETTER solver = new NKLETTER();
		solver.solve(1, in, out);
		out.close();
	}
}

class NKLETTER {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] s1 = in.next().toCharArray();
        char[] s2 = in.next().toCharArray();
        int res = 0;
        int lengthS1 = s1.length;
        int lengthS2 = s2.length;
        int lengthBoth = 0;
        int start = 0;
        if (lengthS1 > lengthS2) {
            start = lengthS1 - lengthS2;
        }

        for (int i = start; i < lengthS1; i++) {
            int j = 0;
            int cnt = 0;
            if (s1[i] == s2[j]) {
                int left = i;
                int right = j;
                while (left < lengthS1 && s1[left] == s2[right]) {
                    cnt++;
                    left++;
                    right++;
                }
                if (left == lengthS1) {
                    res = lengthS1 + lengthS2 - cnt;
                    break;
                }
            }
        }
        if (res == 0) {
            res = lengthS1 + lengthS2;
        }
        out.println(res);
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

