//import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		char s[] = next().toCharArray();
		List<Integer> list = new ArrayList<Integer>();
		int l = s.length;
		int c = 0;
		int sum = 0;
		for (int i = 0; i < l; ++i) {
			if (s[i] == '7') {
				c++;
				sum++;
			} else {
				if (c > 0) {
					list.add(c);
					c = 0;
				}
			}
		}
		if(c>0){
			list.add(c);
		}

		Collections.sort(list);
		long size = list.size();
		if (list.size() == 0) {
			return;
		}
		int max = list.get((int) (size - 1));
		
		StringBuilder str = new StringBuilder();
		int index = 0;
		for (long i = 1; i <= max; ++i) {
			while (list.get(index) < i) {
				sum -= list.get(index);
				index++;
			}
			long r = (sum - (i - 1) * (size - index));

			//System.out.println(i + " " + r);
			str.append(i+" "+r+"\n");
		}
		System.out.println(str);

	}
	
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
