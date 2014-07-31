import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CheckPost {

	public static void main(String[] args) throws IOException {
		ReaderCheckPost reader = new ReaderCheckPost();
		reader.Init(System.in);
		int n = reader.nextInt();

		long[] cost = new long[n];
		for (int i = 0; i < n; ++i) {
			cost[i] = reader.nextLong();
		}
		List<Integer>[] g = new List[n + 1];
		int m = reader.nextInt();
		int x, y;
		for (int i = 0; i < m; ++i) {
			x = reader.nextInt();
			y = reader.nextInt();
			g[x].add(y);
		}

		List<List<Integer>> scComponents = getSCComponents(g);
		// int m = reader.nextInt();

	}

	/** number of vertices **/
	private static int V;
	/** preorder number counter **/
	private static int preCount;
	/** low number of v **/
	private static int[] low;
	/** to check if v is visited **/
	private static boolean[] visited;
	/** to store given graph **/
	private static List<Integer>[] graph;
	/** to store all scc **/
	private static List<List<Integer>> sccComp;
	private static Stack<Integer> stack;

	/** function to get all strongly connected components **/
	public static List<List<Integer>> getSCComponents(List<Integer>[] graph) {
		V = graph.length;
		graph = graph;
		low = new int[V];
		visited = new boolean[V];
		stack = new Stack<Integer>();
		sccComp = new ArrayList<>();

		for (int v = 0; v < V; v++)
			if (!visited[v])
				dfs(v);

		return sccComp;
	}

	/** function dfs **/
	public static void dfs(int v) {
		low[v] = preCount++;
		visited[v] = true;
		stack.push(v);
		int min = low[v];
		for (int w : graph[v]) {
			if (!visited[w])
				dfs(w);
			if (low[w] < min)
				min = low[w];
		}
		if (min < low[v]) {
			low[v] = min;
			return;
		}
		List<Integer> component = new ArrayList<Integer>();
		int w;
		do {
			w = stack.pop();
			component.add(w);
			low[w] = V;
		} while (w != v);
		sccComp.add(component);
	}

}

class ReaderCheckPost {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}