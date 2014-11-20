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
		TaskBKK solver = new TaskBKK();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBKK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Point[] ps = new Point[3];
        for (int i = 0; i < 3; i++) {
            ps[i] = new Point();
            ps[i].x = in.nextLong();
            ps[i].y = in.nextLong();
        }
        Arrays.sort(ps);
        long x,y;
        x = y = 0;
        if(ps[0].x == ps[1].x){
            x = ps[2].x;
            if(ps[2].y == ps[1].y) y = ps[0].y;
            if(ps[2].y == ps[0].y) y = ps[1].y;
        } else {
            x = ps[0].x;
            if(ps[0].y == ps[1].y) y = ps[2].y;
            if(ps[0].y == ps[2].y) y = ps[1].y;
        }
        out.printf("%d %d\n",x,y);
    }
}

class Point implements Comparable<Point>{
    long x;
    long y;

    public int compareTo(Point other){
        if(this.x < other.x) return -1;
        if(this.x == other.x) return 0;
        return 1;
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

    public long nextLong() {
        return Long.parseLong(next());
    }

}

