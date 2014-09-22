import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {

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
        char[] s  = in.next().toCharArray();
        int length = s.length;
        if(length % 2 == 1){
        	out.println("NO");
        	return;
        }
        long[] aphabet = new long[26];
        for(int i = 0; i < length; ++i){
        	aphabet[s[i]- 'a']++;
        }
		
		long max = 0;
        for(int i = 0 ; i < 26;i++){
        	max = Math.max(max,aphabet[i]);
        }
		
		long others = n - max;
        if(max > others){
        	out.println("NO");
        	return;
        }
        out.println("YES");
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