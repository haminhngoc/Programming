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
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSPOJ {

    int[] sum;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int L = in.nextInt();
        int R = in.nextInt();
        generateSum(R);
        long cnt = 0;
        for(int i = L; i <= R; ++i){
            if(sum[i] > i) ++cnt;
        }
        out.println(cnt);
    }

    void generateSum(int R){
        sum = new int[R+1];
        Arrays.fill(sum,1);
        sum[1] = 0;
        for(int i = 2; i <= R/2; ++i){
            for(int j = 2; j*i <= R; ++j){
                sum[i*j] += i;
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

