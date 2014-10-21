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
		QMAX solver = new QMAX();
		solver.solve(1, in, out);
		out.close();
	}
}

class QMAX {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        SegmentTree st = new SegmentTree(n);
        int u,v,k;
        for (int i = 0; i < m; i++) {
            u = in.nextInt()-1;
            v = in.nextInt()-1;
            k = in.nextInt();
            st.update(u,v,k);
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            out.println(st.getMax(u,v));
        }
    }
}

class SegmentTree{
    private long[] tree;
    private long[] lazy;
    int n;

    SegmentTree(int n){
        tree = new long[4*n+5];
        lazy = new long[4*n+5];
        this.n = n;
    }

    void update(int l, int r, int value){
        update(0,0,n-1,l,r,value);
    }

    private void update(int node, int lo, int hi, int l, int r,int value){
        if(lazy[node] != 0){
            tree[node] += lazy[node];
            if(lo != hi){
                lazy[node*2+1] += lazy[node];
                lazy[node*2+2] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(hi < l || lo > r) return;
        if(l <= lo && hi <= r){
            tree[node] += value;
            if(lo != hi){
                lazy[node*2+1] += value;
                lazy[node*2+2] += value;
            }
            return;
        }
        int mid = (lo + hi) >> 1;
        update(node*2+1,lo,mid,l,r,value);
        update(node*2+2,mid+1,hi,l,r,value);
        tree[node] = Math.max(tree[node*2+1],tree[node*2+2]);
    }

    long getMax(int l, int r){
        return internalQuery(0,0,n-1,l,r);
    }

    private long internalQuery(int node, int lo, int hi, int l, int r){
        if(hi < l || lo > r) return 0;
        if(lazy[node] != 0){
            tree[node] += lazy[node];
            if(lo != hi){
                lazy[node*2+1] += lazy[node];
                lazy[node*2+2] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(l <= lo && hi <= r){
            return tree[node];
        }
        int mid = (lo + hi) >> 1;
        long leftNode = internalQuery(node*2+1,lo,mid,l,r);
        long rightNode = internalQuery(node*2+2,mid+1,hi,l,r);
        return Math.max(leftNode,rightNode);
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

