import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
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
		long n,m,k;
		long l,w;
		long ans = 0;
		n = in.nextLong(); // 1e9
		m = in.nextLong(); // 1e9
		k = in.nextLong(); // 1e9
		if (k > (n-1) + (m-1))
		{
			out.println("-1");
			return;
		}
		l = m > n ? m : n;
		w = m > n ? n : m;
		if (k > (l-1))
		{
			long temp = k - (l -1);
			if(w%(temp+1) == 0)
			{
				ans = (w/(temp+1));
			}
			else
			{
				ans = w%(w/(temp+1));
			}
		}
		else if (l%(k+1) == 0)
		{
			ans = (l/(k+1)) * w;
		}
		else if(w%(k+1) == 0)
		{
			ans = (w/(k+1)) * l;
		}
		else
		{
			ans = (l/(k+1))*w;
		}
		out.println(ans);
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
