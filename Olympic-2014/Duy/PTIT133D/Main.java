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
class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		PTIT133D solver = new PTIT133D();
		solver.solve(1, in, out);
		out.close();
	}
}

class PTIT133D {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String[] pattern = new String[]{"Taro", "Taro", "Hanako", "Taro", "Hanako"};
        String check = in.next();
        while (check.equals("[CASE]")) {
            int n = in.nextInt();
            if (n < 4) {
                if (n == 2) {
                    out.println("Hanako");
                } else {
                    out.println("Taro");
                }
            } else {
                int tmp = (n - 3) % 5;
                out.println(pattern[tmp]);
            }
            check = in.next();
        }
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


