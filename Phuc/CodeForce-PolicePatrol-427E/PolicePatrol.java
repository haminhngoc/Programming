import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class PolicePatrol {

	public static void main(String[] args) throws IOException {
		ReaderPolicePatrol reader = new ReaderPolicePatrol();
		reader.Init(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		List<Integer> list =new ArrayList<Integer>();
		long result = 0;
		int temp = reader.nextInt();
		
		for(int i = 1; i <n; ++i){
			
		}

	}

}

class ReaderPolicePatrol {
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