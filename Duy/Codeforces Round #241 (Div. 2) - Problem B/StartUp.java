import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class StartUp {

	public static void main(String[] args) throws IOException {
		StartUp main = new StartUp();
		main.solve();
	}
	void solve() throws IOException
	{
		ReaderStartUp reader = new ReaderStartUp();
		reader.Init(System.in);
		char[] patern = new char[]{'B','C','D','E','F','G','J','K','L','N','P','Q','R','S','Z'};
		char[] inputs = reader.Next().toCharArray();
		int length =inputs.length;
		int paternLength =patern.length;
		for(int i = 0 ; i < length;i++ )
		{
			if(inputs[i] != inputs[length-1-i])
			{
				System.out.print("NO");
				return;
			}
			for(int j = 0 ; j <paternLength;j++)
			{
				if(inputs[i] == patern[j])
				{
					System.out.print("NO");
					return;
				}
			}
		}
		System.out.print("YES");
	}

}
class ReaderStartUp {
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