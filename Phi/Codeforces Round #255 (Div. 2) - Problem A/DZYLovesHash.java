import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
<<<<<<< HEAD
=======
import java.math.BigInteger;
>>>>>>> 077728ba771defb07b906ed45bc48aaa8a6e72f5
import java.util.*;

import sun.awt.RepaintArea;

import com.sun.media.sound.RIFFInvalidDataException;

public class DZYLovesHash {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(in, out);
		out.close();
	}
}

<<<<<<< HEAD
class TaskE {
	List<Integer>[] g;
	int[] parents;
	int[] value;
	int n;

	public void solve(InputReader in, PrintWriter out) {
		n = in.nextInt();
		int q = in.nextInt();
		g = new ArrayList[n];
		parents = new int[n];
		value = new int[n];

		Arrays.fill(parents, -1);
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<Integer>();
			value[i] = in.nextInt();
		}

		int vi;
		int ui;
		for (int i = 0; i < n - 1; i++) {
			vi = in.nextInt() - 1;
			ui = in.nextInt() - 1;
			g[vi].add(ui);
			g[ui].add(vi);
		}

		dfs(0, 0);
		parents[0] = -1;
		int v, w, type;
		int max;
		int k;
		for (int i = 0; i < q; i++) {
			type = in.nextInt();
			if (type == 1) {
				max = -1;
				v = in.nextInt() - 1;
				k = parents[v];
				while(k != -1)
				{
	//				out.println("dfs " + k);
					if(gcd(value[k],value[v]) > 1)
					{
						max = Math.max(max, k+1);
					}
					k = parents[k];
				}
				out.println(max);
				
			} else {
				v = in.nextInt() - 1;
				w = in.nextInt();
				value[v] = w;
			}			
		}
	}

	private void dfs(int i, int parent) {
		parents[i] = parent;
		for (int u : g[i]) {
			if (parents[u] == -1)
				dfs(u, i);
		}
=======
class TaskC {

	void swap(Integer a,Integer b)
	{
		Integer temp = new Integer(a);
		a = new Integer(b);
		b = new Integer(temp);
	}
	
	public void solve(InputReader in, PrintWriter out) {
		Integer a = 5;
		Integer b = 4;
		swap(a,b);
		out.println(a + " " + b);
>>>>>>> 077728ba771defb07b906ed45bc48aaa8a6e72f5
	}

	private int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
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
