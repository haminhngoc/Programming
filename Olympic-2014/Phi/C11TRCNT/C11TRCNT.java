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
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSPOJ {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        for(int i = 0; i < n; ++i){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        long min = Long.MAX_VALUE;
        long minIndex = 0;
        long total = 0;
        long[] cntTri = new long[n];
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j){
                for(int k = j+1; k < n; ++k){
                    if(!collinear(x[i],y[i],x[j],y[j],x[k],y[k])){
                        ++cntTri[i];
                        ++cntTri[j];
                        ++cntTri[k];
                        ++total;
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i){
            if(cntTri[i] < min){
                min = cntTri[i];
                minIndex = i+1;
            }
        }
        out.printf("%d %d",total, minIndex);
    }

    boolean collinear(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
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

