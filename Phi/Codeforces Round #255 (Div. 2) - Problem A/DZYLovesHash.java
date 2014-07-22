import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class DZYLovesHash {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(in, out);
		out.close();
	}
}

class TaskB {
	public void solve(InputReader in, PrintWriter out) {
		int n,s;
		n = in.nextInt();
		s = in.nextInt();
		List<Point> arrK = new ArrayList<Point>();
		Point k = new Point();
		double distance = 0;
		double x,y;
		
		for(int i =0; i < n; i++)
		{
			x = in.nextDouble();
			y = in.nextDouble();
			k.distance = Math.sqrt(x+y);
			k.population = in.nextLong();
		}
		Collections.sort(arrK, new Comparator<Point>() {
		    public int compare(Point p1, Point p2) {
		        return p1.distance > p2.distance ? 1: -1;
		    }
		});
		for(int i =0; i < n; i++)
		{
			
		}
	}
}

class Point
{
	double distance;
	long population;
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
	public float nextDouble(){
		return (float) Double.parseDouble(next());
	}

}
