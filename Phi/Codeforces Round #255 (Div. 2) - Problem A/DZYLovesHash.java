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
		TaskC solver = new TaskC();
		solver.solve(in, out);
		out.close();
	}
}

class TaskC {
	private static long ans = 0;
	private static Long[] a = new Long[5000];

	public void solve(InputReader in, PrintWriter out) {
		int n;
		n = in.nextInt(); // 5000
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong(); // 10^9
		}
		Calculate(0,n-1);
		out.println(ans);
	}

	private void Calculate(int l, int r) {
		if (r < l) return;
		if (r == l)
		{
			ans++;
			return;
		}
		long max = 0;
		int iMax = 0;
		int n1 = 0;
		int nextL = l;
		for (int i = l; i <= r; i++) {
			if(a[i] > max)
			{
				max = a[i];
				iMax = i;
			}
			if(a[i] == 1)
			{
				n1++;
			}
		}
		if (n1 > 1)
		{
			for (int i = l; i <= r; i++) {
				a[i]--;
			}
		}
		else if (max > r-l +1)
		{
			a[iMax] = (long)0;
		}
		else
		{
			for (int i = l; i <= r; i++) {
				a[i]--;
			}
		}
		ans++;
		for (int i = l; i <= r; i++) {
			if(a[i] == 0)
			{
				Calculate(nextL,i-1);
				nextL = i+1;
			}
			else if(i == r)
			{
				Calculate(nextL,r);
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
