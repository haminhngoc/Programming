import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class DZYLovesStrings {

	public static void main(String[] args) throws IOException {
		DZYLovesStrings main = new DZYLovesStrings();
		main.solve();

	}

	void solve() throws IOException {
		Reader6 reader = new Reader6();
		reader.Init(System.in);
		String s = reader.Next();
		int k = reader.NextInt();
		Vector letterValues = new Vector();
		int result = 0;
		int input = 0;
		int max = 0;
		for(int i = 0 ; i < 26 ;i++)
		{
			input = reader.NextInt();
			letterValues.add(input);
			if(input > max)
			{
				max = input;
			}
			
		}
		for(int i = 0; i<s.length();i++)
		{
			int temp = s.charAt(i)-'a';
			result += (int)letterValues.get(temp)*(i+1);
		}
		for(int i = k ; i > 0 ;i--)
		{
			result += max*(i+s.length());
		}
		System.out.print(result);
	}
}

class Reader6 {
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