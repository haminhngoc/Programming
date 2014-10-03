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
        HoiTruong_2187 solver = new HoiTruong_2187();
        solver.solve(1, in, out);
        out.close();
    }
}

class HoiTruong_2187 {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        book[] a = new book[n];

        for (int i = 0; i < n; i++) {
            a[i] = new book();
            a[i].p = in.nextInt();
            a[i].k = in.nextInt();
        }
        Arrays.sort(a);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = a[i].k - a[i].p;
            for (int j = 0; j < i; j++) {
                if (a[j].k <= a[i].p) {
                    dp[i] = Math.max(dp[i], dp[j] + (a[i].k - a[i].p));
                }
            }
            res = Math.max(res,dp[i]);
        }
        out.println(res);
    }
}

class book implements Comparable<book>{
    int p;
    int k;

    public int compareTo(book b1) {
        return this.p - b1.p;
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

