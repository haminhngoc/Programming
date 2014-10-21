import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collections;
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
		VMGOLD solver = new VMGOLD();
		solver.solve(1, in, out);
		out.close();
	}
}

class VMGOLD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        long a;
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            a = in.nextLong();
            long j;
            for(j = 1; j*j < a; ++j){
                if(a % j == 0){
                    list.add(j);
                    list.add(a/j);
                }
            }
            if(j*j == a){
                list.add(j);
            }
        }
        Collections.sort(list);
        int cnt = 1;
        int size = list.size() - 1;
        long curVal = list.get(size);
        for(int i = size-1; i >= 0; --i){
            if(list.get(i) == curVal) ++cnt;
            if(list.get(i) != curVal){
                if(cnt >= k){
                    out.println(curVal);
                    return;
                }
                curVal = list.get(i);
                cnt = 1;
            }
        }
        out.println(1);
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

