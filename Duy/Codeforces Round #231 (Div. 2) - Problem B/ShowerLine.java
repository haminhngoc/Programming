import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ShowerLine {

	static String[] perm;
	static int index =0;
	
	public static void main(String[] args) throws IOException {
		ShowerLine main = new ShowerLine();
		main.solve();
	}

	void solve() throws IOException {
		ReaderShowerLine reader = new ReaderShowerLine();
		reader.Init(System.in);
		int[][] matrix = new int[5][5];
		perm = new String[120];
		perm1("","01234");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix[i][j] = reader.NextInt();
			}
		}
		long max = Long.MIN_VALUE;
		long res = 0;
		for(int i = 0 ; i < 120;i++)
		{
			res = matrix[perm[i].charAt(0)-48][perm[i].charAt(1)-48] + matrix[perm[i].charAt(1)-48][perm[i].charAt(0)-48]
					+matrix[perm[i].charAt(1)-48][perm[i].charAt(2)-48] + matrix[perm[i].charAt(2)-48][perm[i].charAt(1)-48]
							+2*(matrix[perm[i].charAt(2)-48][perm[i].charAt(3)-48] + matrix[perm[i].charAt(3)-48][perm[i].charAt(2)-48])
									+2*(matrix[perm[i].charAt(3)-48][perm[i].charAt(4)-48] + matrix[perm[i].charAt(4)-48][perm[i].charAt(3)-48]);
			if(res > max)
			{
				max = res;
			}
		
		}
		
		System.out.print(max);
		 
	}

	

	void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0){
			perm[index] = prefix;
			index++;
		}
		else {
			for (int i = 0; i < N; i++)
				perm1(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N));
		}

	}
}


class ReaderShowerLine {
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