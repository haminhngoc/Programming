import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Football {

	public static void main(String[] args) throws IOException {
		ReaderFootball reader = new ReaderFootball();
		reader.Init(System.in);
		int n = reader.nextInt();
		int k = reader.nextInt();
		if (k > (n - 1) / 2) {
			System.out.println(-1);
			return;
		}
		// int[][] arr = new int[n + 1][n + 1];

		System.out.println(k * n);
		int count;
		int j;
		String output= "";
		for (int i = 1; i <= n; ++i) {
			count = 0;
			output="";
			if (i == n) {
				j = 1;
			} else {
				j = i + 1;
			}
			for (count = 0; count < k; ++count) {

				//System.out.println(i + " " + j);
				output+= i +" "+j +"\n";
				if(output.length()>1000){
					System.out.println(output);
					output="";
				}
				if (j == n) {
					j = 1;
				} else {
					j++;
				}
			}
			System.out.println(output);
		}
		
	}

}

class ReaderFootball {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}