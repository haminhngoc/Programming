import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;


class VOSRTRI {

	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		int n;// n=100000;
		n = reader.nextInt();

		long[] x = new long[100001];
		long[] y = new long[100001];
		int[] X = new int[n];
		int[] Y = new int[n];
		for (int i = 0; i < n; i++) {
			X[i] = reader.nextInt();
			Y[i] = reader.nextInt();
			x[X[i]]++;
			y[Y[i]]++;
		}
		long count = 0;
		for (int i = 0; i < n; i++) {
			if (x[X[i]] > 1 && y[Y[i]] > 1)
				count += (x[X[i]] - 1) * (y[Y[i]] - 1);
		}

		System.out.println(count);
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

}