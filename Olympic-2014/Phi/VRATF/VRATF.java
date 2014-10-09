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
		VRATF solver = new VRATF();
		solver.solve(1, in, out);
		out.close();
	}
}

class VRATF {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int d = in.nextInt();
        int numberOfGroup = cal(n,d);
        out.println(numberOfGroup);
    }

    int cal(int n,int d){
        int a = (n+d) >> 1;
        int b = n - a;
        if(a-b != d || b <= 0 || a <= 0){
            return 1;
        }
        return cal(a,d) + cal(b,d);
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

