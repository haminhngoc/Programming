import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskG solver = new TaskG();
		solver.solve(in, out);
		out.close();
	}
}

class TaskG {

	boolean[][] wall;
	boolean[][] gold;
	boolean[][] trap;
	boolean[][] visited;
	int cnt;
	int W,H;
	
	public void solve(InputReader in, PrintWriter out) {
		W = in.nextInt();
		H = in.nextInt();
		char[] row;
		cnt = 0;
		wall = new boolean[H][W];
		gold = new boolean[H][W];
		trap = new boolean[H][W];
		visited = new boolean[H][W];
		int startX = 0;
		int startY = 0;
		for(int i = 0; i < H; ++i){
			row = in.next().toCharArray();
			for(int j = 0; j < W; ++j){
				if(row[j] == '#'){
					wall[i][j] = true;
				}
				if(row[j] == 'T'){
					trap[i][j] = true;
				}
				if(row[j] == 'G'){
					gold[i][j] = true;
				}
				if(row[j] == 'P'){
					startX = i;
					startY = j;
				}
			}
		}
		dfs(startX,startY);
		out.println(cnt);
	}
	
	void dfs(int i, int j){
		boolean safe = true;
		if(visited[i][j]) return;
		visited[i][j] = true;
		if(gold[i][j]){
			++cnt;
		}
		if(i > 0){ // trap below
			if(trap[i-1][j]){
				safe = false;
			}
		}
		if(i+1 < H){
			if(trap[i+1][j]){
				safe = false;
			}
		}
		if(j + 1 < W){
			if(trap[i][j+1]){
				safe = false;
			}
		}
		if(j > 0){
			if(trap[i][j-1]){
				safe = false;
			}
		}
		if(!safe) return;
		
		if(i > 0){ 
			if(!wall[i-1][j]){
				dfs(i-1,j);
			}
		}
		if(i+1 < H){
			if(!wall[i+1][j]){
				dfs(i+1,j);
			}
		}
		if(j + 1 < W){
			if(!wall[i][j+1]){
				dfs(i,j+1);
			}
		}
		if(j > 0){
			if(!wall[i][j-1]){
				dfs(i,j-1);
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

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

}