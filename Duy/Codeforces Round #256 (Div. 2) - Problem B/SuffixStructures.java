import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;


public class SuffixStructures {

	public static void main(String[] args) throws IOException {
		SuffixStructures main = new SuffixStructures();
		main.solve();
	}
	void solve() throws IOException
	{
		ReaderSuffixStructures reader = new ReaderSuffixStructures();
		reader.Init(System.in);
		String s = reader.Next();
		String t = reader.Next();
		String sortedT = sortString(t);
		String sortedS = sortString(s);
		int sizeOfS = s.length();
		int sizeOfT = t.length();
		String subString = "";
		if(sortedT.equals(sortedS))
		{
			System.out.print("array");
			return;
		}
		if(CheckAutomaton(s,t))
		{
			System.out.print("automaton");
			return;
		}
		if(CheckBoth(s,t))
		{
			System.out.print("both");
			return;
		}
		
		System.out.print("need tree");
	}

	private boolean CheckBoth(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int sizeOfS = s.length();
		int sizeOfT = t.length();
		int[] label = new int[sizeOfS];
		int count =0;
		for(int i = 0 ; i < sizeOfT ;i++)
		{
			for(int j = 0; j < sizeOfS ;j++)
			{
				if(tt[i] == ss[j] && label[j] == 0)
				{
					count++;
					label[j] =1;
					break;
				}
			}
		}
		if(count >= sizeOfT)
		{
			return true;
		}
			return false;
	}
	private boolean CheckAutomaton(String s,String t)
	{
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int sizeOfS = s.length();
		int sizeOfT = t.length();
		int count =0;
		
		int j =0;
		for(int i = 0 ; i < sizeOfT ;i++)
		{
			for(; j < sizeOfS ;j++)
			{
				if(tt[i] == ss[j])
				{
					count++;
					j++;
					break;
				}
			}
		}
		if(count >= sizeOfT)
		{
			return true;
		}
			return false;
	}
	String sortString(String input)
	{
		String result;
		char[] inputs = input.toCharArray();
		Arrays.sort(inputs);
		result = new String(inputs); 
		return result;
	}
}
class ReaderSuffixStructures {
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