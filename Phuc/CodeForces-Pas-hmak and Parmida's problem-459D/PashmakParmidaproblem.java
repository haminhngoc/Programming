import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PashmakParmidaproblem {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();

		List<Integer> list = new ArrayList<Integer>();
		int temp;
		for (int i = 0; i < n; ++i) {
			temp = nextInt();
			list.add(temp);
		}

		Collections.sort(list);

		int count = 1;
		list.add(0);
		List<Integer> countList = new ArrayList<Integer>();

		for (int i = 1; i <= n; ++i) {
			countList.add(count);
			if (list.get(i) != list.get(i - 1)) {
				count = 0;
			}
			count++;
		}
		//countList.add(count);
		List<Integer> countListR = new ArrayList<Integer>();
		Collections.sort(countList);

		int size = countList.size();

		temp = 0;
		count = 0;
		int i = 0;
		long result = 0;
		while (i < size && countList.get(i) == 1) {
			temp++;
			i++;
		}
		if (i != size) {
			while (i < size) {
				if (countList.get(i) != countList.get(i - 1)) {
					temp += count;
					count = 0;
				}
				count++;
				result += temp;
				i++;
			}
		}
		
		System.out.println(result);
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
