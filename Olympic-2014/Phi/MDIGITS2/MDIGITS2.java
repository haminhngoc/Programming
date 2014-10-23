import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		MDIGITS2 solver = new MDIGITS2();
		solver.solve(1, in, out);
		out.close();
	}
}

class MDIGITS2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = Integer.toString(n);

        int l = s.length();
        StringBuilder t = new StringBuilder();
        StringBuilder cur;
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            cur = new StringBuilder(Integer.toString(i));
            while(cur.length() != 0){
                t.append(cur.charAt(0));
                ++pos;
                cur.deleteCharAt(0);
                if(t.length() > l) t.deleteCharAt(0);
                if(t.toString().equals(s)){
                    out.println(pos-l+1);
                    return;
                }
            }
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

