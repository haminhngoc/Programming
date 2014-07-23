import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class KuriyamaMiraiStones {

	public static void main(String[] args) throws IOException {
		KuriyamaMiraiStones main = new KuriyamaMiraiStones();
		main.solve();
	}

	void solve() throws IOException {
		ReaderKuriyamaMiraiStones reader = new ReaderKuriyamaMiraiStones();
		reader.Init(System.in);
		int n = reader.NextInt(); // 10^5
		List<Long> inputs = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			inputs.add(reader.NextLong());
		}
		int m = reader.NextInt(); // 10^5
		int[] types = new int[m];
		int[] ls = new int[m];
		int[] rs = new int[m];
		for (int i = 0; i < m; i++) {
			types[i] = reader.NextInt();
			ls[i] = reader.NextInt();
			rs[i] = reader.NextInt();
		}
		List<Long> inputsSorted = new ArrayList<Long>();
		for(int i = 0 ; i < n ;i++)
		{
			inputsSorted.add(inputs.get(i));
		}
		Collections.sort(inputsSorted);
		long[] sumType1s = new long[n+1];
		long[] sumType2s = new long[n+1];
		sumType1s[0] = 0;
		sumType2s[0] = 0;
		for (int i = 1; i <= n; i++) {
			sumType1s[i] = inputs.get(i-1) + sumType1s[i - 1];
			sumType2s[i] = inputsSorted.get(i-1) + sumType2s[i - 1];
		}

		for(int i = 0 ; i < m ;i++)
		{
			if(types[i] == 1)
			{
				System.out.print((sumType1s[rs[i]] - sumType1s[ls[i]-1]) + "\n");
			}
			else
			{
				System.out.print((sumType2s[rs[i]] - sumType2s[ls[i]-1]) + "\n");
			}
		}
	}

}

class ReaderKuriyamaMiraiStones {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}