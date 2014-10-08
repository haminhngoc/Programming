import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
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
		C11SEQ3 solver = new C11SEQ3();
		solver.solve(1, in, out);
		out.close();
	}
}

class C11SEQ3 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long x = 1;
        long[] pattern = new long[31];
        pattern[0] = x;
        for (int i = 0; i < 30; i++) {
            long tmp = order(x * 2);
            pattern[i + 1] = tmp;
            x = tmp;
        }
        long res = 0;
        if (n <= 30) {
            res = pattern[n - 1];
        } else {
            int tmp = (n - 25) % 6;
            res = pattern[tmp + 25 - 1];
        }
        out.println(res);
    }

    private long order(long i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        char[] out = sb.toString().toCharArray();
        Arrays.sort(out);
        String c = new String(out);
        return Long.parseLong(c);
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}
