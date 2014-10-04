import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
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
		solver.solve(in, out);
		out.close();
	}
}

class TaskSPOJ {
    public void solve(InputReader in, PrintWriter out) {
    	int max = (int)1e8;
    	int[] base = new int[100];
    	base[1] = 1;
    	int i = 2;
    	while(i <= 50){
    		base[i] = reserve(base[i-1]*2);
    		i++;
    	}
    	int n = in.nextInt();
    	if(n <= 30){
    		out.println(base[n]);
    	} else {
    		n -= 25;
    		n = n%6;
    		out.println(base[25 + n]);
    	}
    }
    
    int reserve(int a){
    	char[] c = Integer.toString(a).toCharArray();
    	Arrays.sort(c);
    	int res = Integer.parseInt(new String(c));
    	return res;
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

}
