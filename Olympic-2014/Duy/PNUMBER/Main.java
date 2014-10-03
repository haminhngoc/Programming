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
        TimSoNguyenTo_1783 solver = new TimSoNguyenTo_1783();
        solver.solve(1, in, out);
        out.close();
    }
}

class TimSoNguyenTo_1783 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int from = in.nextInt();
        int to = in.nextInt();
        from = Math.max(2, from);
        for (int cur = from; cur <= to; cur++) {
            if (isPrime(cur)) {
                out.println(cur);
            }
        }
    }

    static boolean isPrime(int cur) {
        for (int i = 2; i <= Math.sqrt(cur); i++) {
            if (cur % i == 0) {
                return false;
            }
        }
        return true;
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

