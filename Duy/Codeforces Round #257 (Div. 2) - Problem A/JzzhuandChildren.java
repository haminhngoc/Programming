import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JzzhuandChildren {

	public static void main(String[] args) throws IOException {
		JzzhuandChildren main = new JzzhuandChildren();
		main.solve();
	}

	void solve() throws IOException {
		ReaderJzzhuandChildren reader = new ReaderJzzhuandChildren();
		reader.Init(System.in);
		int n = reader.NextInt();
		int m = reader.NextInt();
		List<Integer> inputs = new ArrayList<Integer>();
		List<Integer> ith = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			temp = reader.NextInt();
			inputs.add(temp);
			ith.add(i+1);
		}
		int size = inputs.size();
		
		while (size > 1) {
			for (int i = 0; i < size; i++) {
				temp = inputs.get(i);
				if (temp > m) {
					inputs.set(i, temp-m);
				}
				else
				{
					inputs.remove(i);
					ith.remove(i);
					if(inputs.size()==1)
					{
						System.out.print(ith.get(ith.size() - 1));
						return;
					}
					size--;
					i--;
				}
			}
		}
		System.out.print(1);

	}
}

class ReaderJzzhuandChildren {
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