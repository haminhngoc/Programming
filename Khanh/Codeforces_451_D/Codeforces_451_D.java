import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces_451_D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Init(System.in);
		String s = Next();
		int n = s.length();
		char[] arrS = new char[n];
		arrS = s.toCharArray();
		int oddA = 0, evenA = 0;
		int oddB = 0, evenB = 0;
		for (int i = 0; i < n; i++) {
			if ((i + 1) % 2 == 0) {
				if (arrS[i] == 'a')
					evenA++;
				else
					evenB++;
			} else {
				if (arrS[i] == 'a')
					oddA++;
				else
					oddB++;
			}
		}
		long even , odd;
		long sum[] = new long[n+1];
		sum[0] = 0;
		for (int i = 1; i < n+1; i++)
			sum[i] = (long) i + sum[i - 1];
		odd = sum[oddA] + sum[evenA] + sum[oddB] + sum[evenB];
		even = (long) oddA * evenA + (long) oddB * evenB;
		System.out.println(even + " " + odd);
	}

	/******************************************************************
	 ****************************** READER*****************************
	 ******************************************************************/
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

	static double NextDouble() throws IOException {

		return Double.parseDouble(Next());
	}

}
