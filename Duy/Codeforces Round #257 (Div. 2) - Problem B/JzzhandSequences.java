import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JzzhandSequences {

	public static void main(String[] args) throws IOException {
		JzzhandSequences main = new JzzhandSequences();
		main.solve();
	}

	void solve() throws IOException {
		ReaderJzzhandSequences reader = new ReaderJzzhandSequences();
		reader.Init(System.in);
		long f1 = reader.NextLong();
		long f2 = reader.NextLong();
		long n = reader.NextLong();
		long fn = 0;

		long f3 = f2 - f1;
		long temp = n / 3;
		long ith = n % 3;
		if (ith == 1) {
			fn = f1;
		}
		if (ith == 2) {
			fn = f2;
		}
		if (ith == 0) {
			fn = f3;
			temp--;
		}
		if (temp % 2 == 1) {
			fn *= -1;
		}
		long res = 0;
		if (fn < 0) {
			res =fn + 1000000007;
			while(res<0)
			{
				res +=1000000007;
			}
		} else {
			res = fn % 1000000007;
		}
		System.out.print(res);
	}
}

class ReaderJzzhandSequences {
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