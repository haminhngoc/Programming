import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class JzzhuandCities {

	public static void main(String[] args) throws IOException {
		ReaderJzzhuandCities reader = new ReaderJzzhuandCities();
		reader.Init(System.in);
		int n = reader.nextInt(); 	//10^5
		int m = reader.nextInt();  //3*10^5
		int k = reader.nextInt(); //10^5

	}

}

class ReaderJzzhuandCities {
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