import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class PoliceRecruits {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
    }
}

class TaskA {
    public void solve(InputReader in, PrintWriter out) {
        int n, ith;
        int ans = 0;
        int last = 0;
        int curCrime = 0;
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            ith = in.nextInt();
            if(ith == -1) curCrime++;
            else
            {
                ans += Math.max(0, curCrime - last);
                last = ith + Math.max(0, last - curCrime);
                curCrime = 0;
            }
        }
        ans += Math.max(0, curCrime - last);
        curCrime = 0;
        out.println(ans);
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

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}