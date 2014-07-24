import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FootballKit {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FootballKit main = new FootballKit();
		main.solve();
	}
	void solve() throws IOException
	{
		ReaderFootballKit reader = new ReaderFootballKit();
		reader.Init(System.in);
		int n = reader.NextInt();//10^5
		int[] homes = new int[n];
		int[] aways = new int[n];
		int[] sumHome = new int[100001];
		int[][] result = new int[n][2];
		int home =0;
		int away = 0;
		for(int i = 0 ; i < n ; i++)
		{
			home = reader.NextInt();
			away = reader.NextInt();
			homes[i] = home;
			aways[i] = away;
			sumHome[home]++;
		}
		int resHome = 0;
		for(int i = 0 ; i < n ;i++)
		{
			resHome=0;
			if(sumHome[aways[i]] != 0)
			{
				resHome+=sumHome[aways[i]];
			}
			result[i][0] = (resHome += n-1);
			result[i][1] = (n-1)*2 - result[i][0];
		}
		for(int i = 0 ; i < n ;i++)
		{
			System.out.print(result[i][0] + " " + result[i][1] + "\n");
		}
	}
}
class ReaderFootballKit {
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