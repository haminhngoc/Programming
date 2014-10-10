import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		VBGRASS solver = new VBGRASS();
		solver.solve(1, in, out);
		out.close();
	}
}

class VBGRASS {
    static int r;
    static int c;
    static boolean[][] label;
    static char[][] field;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        r = in.nextInt();
        c = in.nextInt();
        field = new char[r][];
        for (int i = 0; i < r; i++) {
            field[i] = in.next().toCharArray();
        }
        label = new boolean[r][c];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (field[i][j] == '#' && !label[i][j]) {
                    res++;
                    label[i][j] = true;
                    dfs(i, j);
                }
            }
        }
        out.println(res);
    }

    private void dfs(int i, int j) {
        if (i - 1 >= 0 && !label[i - 1][j] && field[i - 1][j] == '#') {
            label[i - 1][j] = true;
            dfs(i - 1, j);
        }
        if (j + 1 < c && !label[i][j + 1] && field[i][j + 1] == '#') {
            label[i][j + 1] = true;
            dfs(i, j + 1);
        }
        if (i + 1 < r && !label[i + 1][j] && field[i + 1][j] == '#') {
            label[i + 1][j] = true;
            dfs(i + 1, j);
        }
        if (j - 1 >= 0 && !label[i][j - 1] && field[i][j - 1] == '#') {
            label[i][j - 1] = true;
            dfs(i, j - 1);
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
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

