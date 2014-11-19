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
		NKGUARD solver = new NKGUARD();
		solver.solve(1, in, out);
		out.close();
	}
}

class NKGUARD {
    int[][] graph;
    int[][] cnt;
    boolean[][] notHill;
    int[] dx = {0,-1,1,0,-1,-1,1,1};
    int[] dy = {-1,0,0,1,-1,1,1,-1};
    boolean isHill;
    int r;
    int c;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        r = in.nextInt();
        c = in.nextInt();
        graph = new int[r][c];
        cnt = new int[r][c];
        notHill = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        int code = 0;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ++code;
                if(!notHill[i][j]){
                    isHill = true;
                    dfs(i,j,graph[i][j],code);
                    if(isHill){
                        ++res;
                    }
                }
            }
        }
        out.println(res);
    }

    void dfs(int x,int y,int value,int code){
        if(graph[x][y] > value){
            isHill = false;
            return;
        }
        cnt[x][y] = code;
        notHill[x][y] = true;
        int nextX;
        int nextY;
        if(graph[x][y] == value){
            for (int i = 0; i < 8; i++) {
                nextX = x + dx[i];
                nextY = y + dy[i];
                if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && cnt[nextX][nextY] != code){
                    dfs(nextX,nextY,value,code);
                }
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

