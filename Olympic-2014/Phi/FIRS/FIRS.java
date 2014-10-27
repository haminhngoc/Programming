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
		FIRS solver = new FIRS();
		solver.solve(1, in, out);
		out.close();
	}
}

class FIRS {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int MAX = (int)1e5;
        boolean[] isDead = new boolean[MAX];
        int n = in.nextInt();
        Tree[] trees = new Tree[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new Tree(in.nextInt(),i);
        }
        int res = 0;
        int cnt = 0;
        Arrays.sort(trees);
        Tree t;
        for(int i = 0; i < n && cnt < n; ++i){
            t = trees[i];
            if(isDead[t.pos]) continue;
            ++res;
            isDead[t.pos] = true;
            ++cnt;
            if(t.pos > 0){
                if(!isDead[t.pos-1]){
                    isDead[t.pos-1] = true;
                    ++cnt;
                }
            }
            if(t.pos + 1 < n){
                if(!isDead[t.pos+1]){
                    isDead[t.pos+1] = true;
                    ++cnt;
                }
            }
        }
        out.println(res);
    }
}

class Tree implements Comparable<Tree>{
    int value;
    int pos;

    Tree(int v,int p){
        this.value = v;
        this.pos = p;
    }

    public int compareTo(Tree other) {
        if(this.value != other.value)
            return this.value - other.value;
        return this.pos - other.pos;
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

