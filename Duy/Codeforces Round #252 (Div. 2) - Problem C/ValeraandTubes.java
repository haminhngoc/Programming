import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValeraandTubes {

	public static void main(String[] args) throws IOException {
		ValeraandTubes main = new ValeraandTubes();
		main.solve();
	}

	void solve() throws IOException {
		Reader3 reader = new Reader3();
		reader.Init(System.in);
		int n = reader.NextInt();
		int m = reader.NextInt();
		int numbOfTubes = reader.NextInt();
		int size = (n * m) / numbOfTubes;
		List<Cell> datas = new ArrayList<Cell>();
		Cell cell;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					cell = new Cell(i + 1, j + 1);
					datas.add(cell);
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					cell = new Cell(i + 1, j + 1);
					datas.add(cell);
				}
			}
		}
		int j = 0;
		int nn = 0;
		for (int i = 0; i < numbOfTubes; i++) {
			if ((n * m) % numbOfTubes != 0 && i == numbOfTubes - 1) {
				size += (n * m) % numbOfTubes;
			}
			System.out.print(size);
			nn += size;
			for (; j < nn; j++) {
				System.out.print(" " + datas.get(j).x + " " + datas.get(j).y);
			}
			System.out.print("\n");
		}
	}

}

class Cell {
	int x;
	int y;

	public Cell(int x1, int y1) {
		x = x1;
		y = y1;
	}
}

class Reader3 {
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