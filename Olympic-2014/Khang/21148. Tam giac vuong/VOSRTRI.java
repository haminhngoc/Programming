import java.io.*;
import java.util.*;

class VOSRTRI {

	public static void main(String[] args) {
		Solve21148 solver = new Solve21148();
		solver.solve();
	}

}

class Solve21148 {
	InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    
	public void solve() {
		int n = in.nextInt();
		int[] Ox = new int[(int)10e5 + 1];
		int[] Oy = new int[(int)10e5 + 1];
		ArrayList<Point> points = new ArrayList<Point>();
		
		for (int i = 0; i < n; i++) {
			Point point = new Point(in.nextInt(), in.nextInt());
			Ox[point.getX()]++;
			Oy[point.getY()]++;
			points.add(point);
		}
		int result = 0;
		for (Point item : points) {
			result += (Ox[item.getX()] - 1) * (Oy[item.getY()] - 1);
		}
		System.out.println(result);
	}
}

class Point {
	int x = 0;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int y = 0;
	
	public Point(int x, int y) {
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