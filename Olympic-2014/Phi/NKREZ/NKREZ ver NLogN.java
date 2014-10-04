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

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Request[] rs = new Request[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            rs[i] = new Request();
            rs[i].in = in.nextInt();
            rs[i].out = in.nextInt();
            max = Math.max(max,rs[i].out);
        }
        Arrays.sort(rs);
        long[] dp = new long[max+1];
        long res = 0;
        SegmentTree st = new SegmentTree(max+1);
        for(int i = 0; i < n; ++i){
            dp[rs[i].out] = st.getMax(0,rs[i].in) +  rs[i].out - rs[i].in;
            st.update(rs[i].out,dp[rs[i].out]);
            res = Math.max(dp[rs[i].out],res);
        }
        out.println(res);
    }
}

class Request implements Comparable<Request>{
    int in;
    int out;
    public int compareTo(Request other) {
        return out - other.out;
    }
}

class SegmentTree{
    long[] tree;
    int n;
    SegmentTree(int n){
        this.n = n;
        tree = new long[4*n+2];
    }

    void update(int index, long value){
        internalupdate(0,0,n,index,value);
    }

    private void internalupdate(int node, int l, int r, int index,long value){
        if(index < l || index > r) return;
        if(l == r){
            tree[node] = value;
            return;
        }
        int mid = (l + r) >> 1;
        internalupdate(node*2+1,l,mid,index,value);
        internalupdate(node*2+2,mid+1,r,index,value);
        tree[node] = Math.max(tree[node*2+1],tree[node*2+2]);
    }

    long getMax(int u, int v){
        return query(0,0,n,u,v);
    }

    private long query(int node,int l, int r,int u, int v){
        if(v < l || u > r) return 0;
        if(u <= l && r <= v){
            return tree[node];
        }
        int mid = (l + r) >> 1;
        long leftnode = query(node*2+1,l,mid,u,v);
        long rightnode = query(node*2+2,mid+1,r,u,v);
        return Math.max(leftnode,rightnode);
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

