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

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		FWATER solver = new FWATER();
		solver.solve(1, in, out);
		out.close();
	}
}

class FWATER {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] wi = new int[n];

        for (int i = 0; i < n; i++) {
            wi[i] = in.nextInt();
        }

        int[][] pi = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pi[i][j] = in.nextInt();
            }
        }
        List<Edge> list = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            list.add(new Edge(n,i,wi[i]));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                list.add(new Edge(i,j,pi[i][j]));
            }
        }

        UnionSet set = new UnionSet(n+1);
        Edge edge;
        int res = 0;
        Collections.sort(list);
        int nEdge = 0;
        while(list.size() != 0 && nEdge < n){
            edge = list.get(0);
            list.remove(0);
            if(!set.isSameSet(edge.x,edge.y)){
                res += edge.cost;
                ++nEdge;
                set.unionSet(edge.x,edge.y);
            }
        }
        out.println(res);
    }
}

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int cost;

    Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

class UnionSet {
    int[] pset;

    UnionSet(int n){
        pset = new int[n];
        for (int i = 0; i < n; i++) {
            pset[i] = i;
        }
    }

    int findSet(int i){
        if(pset[i] == i) return i;
        return pset[i] = findSet(pset[i]);
    }

    void unionSet(int i, int j){
        pset[findSet(i)] = findSet(j);
    }

    boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j);
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

