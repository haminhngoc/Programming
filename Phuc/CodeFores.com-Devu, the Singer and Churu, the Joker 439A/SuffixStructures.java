import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuffixStructures {

	public static void main(String[] args) throws IOException {

		ReaderSuffixStructures in = new ReaderSuffixStructures();
		ReaderSuffixStructures.Init(System.in);
		String s1 = ReaderSuffixStructures.next();
		String s2 = ReaderSuffixStructures.next();
		char[] s = s1.toCharArray();
		char[] t = s2.toCharArray();
		if (checkSubString(s, t)) {
			System.out.println("automaton");
			return;
		}
		int check = checkArray(s, t);
		if (check==0) {
			System.out.println("array");
		}
		else if(check==1)
		{
			System.out.println("both");
		}

		else {
			System.out.println("need tree");
		}
	}

	private static boolean checkSubString(char[] s, char[] t) {
		int sLength = s.length;
		int tLength = t.length;
		//int end = s.length - t.length;
		int j = 0;
		for(int i =0; i<tLength; ){
			for(; j<sLength; ++j){
				if(t[i]==s[j]){
					j++;
					i++;
					break;
				}
				
			}
			if(i<tLength&&j>=sLength){
				return false;
			}
		}
		return true;
	}

	private static int checkArray(char[] s, char[] t) {
		int sLength = s.length;
		int tLength = t.length;

		boolean[] checked = new boolean[sLength];

		int j = 0;
		for (int i = 0; i < tLength; ++i) {
			for (j = 0; j < sLength; ++j) {
				if (checked[j] == false && t[i] == s[j]) {
					checked[j] = true;
					break;
				}
			}
			if (j >= sLength) {
				return -1;
			}
		}
		if (sLength != t.length) {
			return 1;
		}
		return 0;
	}

}

class ReaderSuffixStructures {
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