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
		C11PINES solver = new C11PINES();
		solver.solve(1, in, out);
		out.close();
	}
}

class C11PINES {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        long res = 0;
        boolean can = true;
        for (int i = 1; i < n; i++) {
            if((a[i] - a[0]) % d == 0){
                res += (a[i] - a[0])/d;
            } else {
                can = false;
                break;
            }
        }
        if(can){
            out.println(res);
        } else {
            out.println(-1);
        }
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

