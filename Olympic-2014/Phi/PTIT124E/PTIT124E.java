import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
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
		TaskBKK solver = new TaskBKK();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBKK {
    List<Integer>[] graph;
    boolean[] visited;
    int[] cnt;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        cnt = new int[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] people = new int[k];
        for (int i = 0; i < k; i++) {
            people[i] = in.nextInt() - 1;
        }
        int u,v;
        for (int i = 0; i < m; i++) {
            u = in.nextInt() - 1;
            v = in.nextInt() - 1;
            graph[u].add(v);
        }
        for (int i = 0; i < k; i++) {
            visited = new boolean[n];
            dfs(people[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(cnt[i] == k){
                ++res;
            }
        }
        out.println(res);
    }

    void dfs(int u){
        visited[u] = true;
        ++cnt[u];
        for(int v : graph[u]){
            if(!visited[v]){
                dfs(v);
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

