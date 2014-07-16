import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DZYLovesChessboard {

	public static void main(String[] args) throws IOException {
		DZYLovesChessboard main = new DZYLovesChessboard();
		main.solve();
	}

	void solve() throws IOException {
		Reader reader = new Reader();
		reader.Init(System.in);
		int n = reader.NextInt();
		int m = reader.NextInt();
		char[][] input = new char[n][m];
		char[][] result = new char[n][m];
		for (int i = 0; i < n; i++) {
			String temp = reader.Next();
			for (int j = 0; j < m; j++) {
				input[i][j] = temp.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (input[i][j] == '.') {
					if(i % 2 == 0 && j %2 ==0)
					{
						input[i][j] = 'W';
					}
					if(i % 2 != 0 && j %2 !=0)
					{
						input[i][j] = 'W';
					}
					if(i % 2 == 0 && j %2 !=0)
					{
						input[i][j] = 'B';
					}
					if(i % 2 != 0 && j %2 ==0)
					{
						input[i][j] = 'B';
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(input[i][j]);
			}
			System.out.print("\n");
		}
	}
}

class Reader {
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

	static String[] NextMxN() throws IOException {
		String result = reader.readLine();
		String[] result1 = result.split(" ");
		return result1;
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