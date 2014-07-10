import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class DZYLovesChemistry {

	public static void main(String[] args) throws IOException {
		DZYLovesChemistry main = new DZYLovesChemistry();
		main.solve();
	}

	void solve() throws IOException {
		Reader reader = new Reader();
		int firstChemical = 0;
		int secondChemical = 0;
		reader.Init(System.in);
		int n = reader.NextInt();
		int m = reader.NextInt();
		Vector first = new Vector();
		Vector second = new Vector();
		for (int i = 0; i < m; i++) {
			firstChemical = reader.NextInt();
			secondChemical = reader.NextInt();
			first.addElement(firstChemical);
			second.addElement(secondChemical);
		}
		int countReact = 0;
		for(int i = 0; i < m;i++)
		{
			/*if(result.elementAt(i)==result.elementAt(i+1))
			{
				countReact++;
			}*/
		}
		
		if (countReact > 0) {
			countReact--;
		}
		System.out.print((int) Math.pow(2, countReact));
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