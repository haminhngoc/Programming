import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class VBGRASS {
	static char[][] arr = new char[100][100];
	static int row = 0;
	static int col = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader2719 in = new InputReader2719(inputStream);

		row = in.nextInt();
		col = in.nextInt();

		for (int i = 0; i < row; i++) {
			String s = in.next();
			arr[i] = s.toCharArray();
		}

		int count = 0;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (arr[i][j] == '#') {
					count++;
					delBrush(i, j);
				}
		
		System.out.println(count);
	}

	private static void delBrush(int i, int j) {
		// TODO Auto-generated method stub
		arr[i][j] = '.';
		if (i > 0 && arr[i - 1][j] == '#')
			delBrush(i - 1, j);
		if (i < row - 1 && arr[i + 1][j] == '#')
			delBrush(i + 1, j);
		if (j > 0 && arr[i][j - 1] == '#')
			delBrush(i, j - 1);
		if (j < col - 1 && arr[i][j + 1] == '#')
			delBrush(i, j + 1);
	}
}

class InputReader2719 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader2719(InputStream stream) {
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

}