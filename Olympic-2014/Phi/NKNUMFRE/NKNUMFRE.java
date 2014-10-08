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
		NKNUMFRE solver = new NKNUMFRE();
		solver.solve(1, in, out);
		out.close();
	}
}

class NKNUMFRE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int l = in.nextInt();
        int r = in.nextInt();
        int cnt = 0;
        for (int i = l; i <= r ; i++) {
            if(gcd(i,reserve(i)) == 1){
                ++cnt;
            }
        }
        out.println(cnt);
    }

    int reserve(int a){
        StringBuilder sb = new StringBuilder(Integer.toString(a));
        return Integer.parseInt(sb.reverse().toString());
    }

    int gcd(int a, int b){
        int t;
        while(b != 0){
            t = b;
            b = a%b;
            a = t;
        }
        return a;
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

