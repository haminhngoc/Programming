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
    char[][] graph;
    boolean[][] visited;
    int Y;
    int X;
    int cnt;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Y = in.nextInt();
        X = in.nextInt();
        graph = new char[Y][X];
        visited = new boolean[Y][X];
        cnt = 0;
        for(int i = 0; i < Y; ++i){
            graph[i] = in.next().toCharArray();
        }
        for(int i = 0; i < Y; ++i){
            for(int j = 0; j < X; ++j){
                if(!visited[i][j] && graph[i][j] == '#'){
                    ++cnt;
                    dfs(j,i);
                }
            }
        }
        out.println(cnt);
    }

    void dfs(int x, int y){
            if(visited[y][x] || graph[y][x] != '#') return;
            visited[y][x] = true;
            if(x > 0){
                dfs(x-1,y);
            }
            if(x < X-1){
                dfs(x+1,y);
            }
            if(y > 0){
                dfs(x,y-1);
            }
            if(y < Y-1){
                dfs(x,y+1);
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

