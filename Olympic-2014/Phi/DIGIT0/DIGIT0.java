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
		DIGIT0 solver = new DIGIT0();
		solver.solve(1, in, out);
		out.close();
	}
}

class DIGIT0 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] c = in.next().toCharArray();
        int[] cnt = new int[28];
        int n = c.length;
        for (int i = 0; i < n; i++) {
            ++cnt[c[i]-'a'];
        }
        int count2A = 0;
        int count5A = 0;
        int count2B = 0;
        int count5B = 0;
        long fac;
        for(int i = 2; i <= n; ++i){
            fac = i;
            while(fac%2 == 0){
                ++count2A;
                fac/=2;
            }
            while(fac%5 == 0){
                ++count5A;
                fac/=5;
            }
        }
        for (int i = 0; i < 28; i++) {
            if(cnt[i] > 1){
                for (int j = 2; j <= cnt[i]; j++) {
                    fac = j;
                    while(fac%2 == 0){
                        ++count2B;
                        fac/=2;
                    }
                    while(fac%5 == 0){
                        ++count5B;
                        fac/=5;
                    }
                }
            }
        }

        int count2 = count2A - count2B;
        int count5 = count5A - count5B;
        int res = Math.min(count2,count5);
        out.println(res);
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

}

