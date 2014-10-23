import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;
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
		VMUNCH solver = new VMUNCH();
		solver.solve(1, in, out);
		out.close();
	}
}

class VMUNCH {
    int R;
    int C;
    char[][] g;
    boolean[][] visited;
    int[][] count;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        R = in.nextInt();
        C = in.nextInt();
        g = new char[R][C];
        visited = new boolean[R][C];
        count = new int[R][C];
        int curX = 0, curY = 0;
        for (int i = 0; i < R; i++) {
            g[i] = in.next().toCharArray();
            for (int j = 0; j < C; j++) {
                if(g[i][j] == 'C'){
                    curX = j;
                    curY = i;
                }
            }
        }
        bfs(curX,curY);
        out.println(count[0][0]+1);
    }

    void bfs(int sx, int sy){
        Queue<Point> q = new LinkedList<Point>();
        Point p = new Point(sx,sy);
        int x,y;
        q.add(p);
        while(q.size() != 0){
            p = q.poll();
            x = p.x;
            y = p.y;
            if(g[y][x] == '*') continue;
            if(g[y][x] == '.') ++count[y][x];
            if(x > 0){
                if(!visited[y][x-1]){
                    q.add(new Point(x-1,y));
                    count[y][x-1] = count[y][x];
                    visited[y][x-1] = true;
                }
            }
            if(x < C-1){
                if(!visited[y][x+1]){
                    q.add(new Point(x+1,y));
                    count[y][x+1] = count[y][x];
                    visited[y][x+1] = true;
                }
            }
            if(y > 0){
                if(!visited[y-1][x]){
                    q.add(new Point(x,y-1));
                    count[y-1][x] = count[y][x];
                    visited[y-1][x] = true;
                }
            }
            if(y < R-1){
                if(!visited[y+1][x]){
                    q.add(new Point(x,y+1));
                    count[y+1][x] = count[y][x];
                    visited[y+1][x] = true;
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
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

