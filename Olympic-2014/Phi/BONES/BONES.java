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
		BONES solver = new BONES();
		solver.solve(1, in, out);
		out.close();
	}
}

class BONES {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int MAX = 100;
        int[] cnt = new int[MAX];
        int s1 = in.nextInt();
        int s2 = in.nextInt();
        int s3 = in.nextInt();
        int sum;
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    sum = i+j+k;
                    ++cnt[sum];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < MAX; i++) {
            if(cnt[i] > cnt[max]) max = i;
        }
        out.println(max);
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

}

