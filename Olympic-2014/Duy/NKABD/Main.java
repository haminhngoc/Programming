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
        SoPhongPhu_3620 solver = new SoPhongPhu_3620();
        solver.solve(1, in, out);
        out.close();
    }
}

class SoPhongPhu_3620 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int from = in.nextInt();
        int to = in.nextInt();
        int[] mark = new int[100001];
        Arrays.fill(mark, 1);
        for (int i = 2; i <= to / 2; i++) {
            int tmp = i+i;
            while (tmp <= to) {
                mark[tmp] += i;
                tmp += i;
            }
        }
        int cnt = 0;
        for (int cur = from; cur <= to; cur++) {
            if (mark[cur] > cur) {
                cnt++;
            }
        }
        out.println(cnt);
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

