import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class PrisonTransfer {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }
}

class TaskB {
    public void solve(InputReader in, PrintWriter out) {
        int n,c;
        long t,ith;
        n = in.nextInt();
        t = in.nextLong();
        c = in.nextInt();
        int last = 0;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ith = in.nextLong();
            if (ith > t)
            {
                ans += (i - last -c + 1) > 0 ? (i - last -c + 1) : 0;
                last = i +1;
            }
        }
        ans += (n - last - c + 1) > 0 ? (n - last - c + 1) : 0;
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

}