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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        SegmentTree st = new SegmentTree();
        long res = 0;
        for(int i = 0; i < n; ++i){
            st.update(a[i]);
            res += st.getSum(a[i]);
        }
        out.println(res);
    }
}

class SegmentTree{
    int MAX = 60000;
    int[] tree;
    int sum;
    SegmentTree(){
        tree = new int[MAX*4+5];
    }

    void update(int index){
        internalUpdate(0,0,MAX,index);
    }

    private void internalUpdate(int node, int l, int r, int index){
        if(index < l || r < index) return;
        if(l == r){
            tree[node] += 1;
            return;
        }
        int mid = (l+r) >> 1;
        internalUpdate(node*2+1,l,mid,index);
        internalUpdate(node*2+2,mid+1,r,index);
        tree[node] = tree[node*2+1] + tree[node*2+2];
    }

    int getSum(int value){
        sum = 0;
        sum(0,0,MAX,value+1,MAX);
        return sum;
    }

    private void sum(int node, int lo, int hi, int l, int r){
        if(r < lo || l > hi){
            return;
        }
        if(l <= lo && hi <= r){
            sum += tree[node];
            return;
        }
        int mid = (lo + hi) >> 1;
        sum(node*2+1,lo,mid,l,r);
        sum(node*2+2,mid+1,hi,l,r);
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

