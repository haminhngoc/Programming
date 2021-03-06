import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	int[][] board;
	int[][] safe;
	boolean[][] isCalled;
	Integer[][] res;
	boolean[][] visited;
	int r;
	int c;
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		r = in.nextInt();
		c = in.nextInt();
		board = new int[r][c];
		safe = new int[r][c];
		visited = new boolean[r][c];
		isCalled = new boolean[r][c];
		res = new Integer[r][c];
		for(int i = 0; i < r; ++i){
			Arrays.fill(res[i], Integer.MAX_VALUE);
		}
		int t = in.nextInt();
		int g = in.nextInt();
		int x,y;
		for(int i = 0; i < t; ++i){
			x = in.nextInt()-1;
			y = in.nextInt()-1;
			board[x][y] = 1;
		}
		for(int i = 0; i < g; ++i){
			x = in.nextInt()-1;
			y = in.nextInt()-1;
			board[x][y] = 2;
		}
		dfs(0,0);
		find(0,0,safe[0][0]);
		if(res[r-1][c-1] == Integer.MAX_VALUE){
			out.println(-1);
		} else {
			out.println(res[r-1][c-1]);
		}
	}
	
	void find(int x, int y,int last){
		if(board[x][y] == 1 && board[x][y] == 2){
			return;
		}
		if(x == r-1 && y == c-1){
			res[x][y] = Math.min(last, res[x][y]);
			return;
		}
		res[x][y] = Math.min(safe[x][y],last);
		if(x > 0){
			find(x-1,y,res[x][y]);
		}
		if(x < r-1){
			find(x+1,y,res[x][y]);
		}
		if(y > 0){
			find(x,y-1,res[x][y]);
		}
		if(y < c-1){
			find(x,y+1,res[x][y]);
		}
	}
	
	void dfs(int x, int y){
		if(visited[x][y]){
			return;
		}
		if(board[x][y] == 1){
			safe[x][y] = Integer.MAX_VALUE;
			return;
		}
		if(board[x][y] == 2){
			safe[x][y] = 0;
			return;
		}
		int c1 = Integer.MAX_VALUE;
		if(x > 0){
			dfs(x-1,y);
			c1 = Math.min(c1,safe[x-1][y]);
		}
		if(x < r-1){
			dfs(x+1,y);
			c1 = Math.min(c1,safe[x+1][y]);
		}
		if(y > 0){
			dfs(x,y-1);
				c1 = Math.min(c1, safe[x][y-1]);
		}
		if(y < c-1){
			dfs(x,y+1);
			c1 = Math.min(c1, safe[x][y+1]);
		}
		safe[x][y] = c1+1;
		visited[x][y] = true;
		return;
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