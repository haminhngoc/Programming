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
		NKDIVSEQ solver = new NKDIVSEQ();
		solver.solve(in, out);
		out.close();
	}
}

class NKDIVSEQ {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int i = 1;
        long number = 1;
        long base = 1;
        long remain = 0;
        while(i++ != n){
            if(remain == 0){
                ++base;
                remain = base-1;
                number = ((number/base)+1)*base;
            } else {
                --remain;
                number += base;
            }
        }
        out.println(number);
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

