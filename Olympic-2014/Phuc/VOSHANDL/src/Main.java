import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		Init(System.in);

		char[] s = next().toCharArray();
		StringBuilder result = new StringBuilder();
		int t = nextInt();
		List<Integer>[] list = find(s);

		for (int i = 0; i < t; ++i) {
			char a[] = next().toCharArray();
			int p1 = solve(list, a);

			char b[] = next().toCharArray();
			int p2 = solve(list, b);
			if (p1 == -1 || p2 == -1) {
				result.append(-4);
				result.append("\n");
			} else if (p1 == p2) {
				result.append(-3);
				result.append("\n");
			} else if (p1 < p2) {
				result.append(-1);
				result.append("\n");
			} else {
				result.append(-2);
				result.append("\n");
			}

		}

		System.out.print(result);

	}

	private static int solve(List<Integer>[] list, char[] a) {
		int indices[] = new int[list.length];
		int listLength = list.length;
		for (int i = 0; i < listLength; ++i) {
			indices[i] = list[i].size() - 1;
		}

		int aLength = a.length;
		if (list[a[aLength - 1] - min].size() == 0) {
			return -1;
		}
		int result = list[a[aLength - 1] - min].get(indices[a[aLength - 1]
				- min]);
		indices[a[aLength - 1] - min]--;
		int preIndex = result;
		for (int i = aLength - 2; i >= 0; --i) {
			preIndex = lowerBound(list[a[i] - min], preIndex);
			if (preIndex == -1) {
				return -1;
			}
		}

		return result;
	}

	private static int lowerBound(List<Integer> list, int preIndex) {

		if (list.size() == 0 || list.get(0) >= preIndex) {

			return -1;
		}
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (list.get(mid) >= preIndex) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		if (list.get(left) >= preIndex) {

			return left == 0 ? -1 : list.get(left - 1);

		} else {
			return list.get(left);
		}
	}

	private static List<Integer>[] find(char[] s) {
		min = Math.min('a', 'A');
		max = Math.max('z', 'Z');
		min = Math.min(min, '0');
		max = Math.max(max, '9');
		min = Math.min(min, '.');
		max = Math.max(max, '.');
		min = Math.min(min, '_');
		max = Math.max(max, '_');
		min = Math.min(min, '[');
		max = Math.max(max, '[');
		min = Math.min(min, ']');
		max = Math.max(max, ']');
		int length = max - min + 1;
		List<Integer>[] result = new List[length];
		for (int i = 0; i < length; ++i) {
			result[i] = new ArrayList<Integer>();
		}

		int sLength = s.length;
		for (int i = 0; i < sLength; ++i) {
			result[s[i] - min].add(i);
		}
		return result;
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
