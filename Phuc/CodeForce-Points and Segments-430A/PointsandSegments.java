import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class PointsandSegments {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int m = nextInt();

		Items[] items = new Items[n];
		for (int i = 0; i < n; ++i) {
			items[i] = new Items();
			items[i].Position = i;
			items[i].value = nextInt();
		}
		Segment[] segments = new Segment[m];
		for (int i = 0; i < m; ++i) {
			segments[i] = new Segment();
			segments[i].left = nextInt();
			segments[i].right = nextInt();
		}

		Arrays.sort(items, new Comparator<Items>() {
			@Override
			public int compare(Items o1, Items o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});
		for (int i = 0; i < n; ++i) {
			items[i].color = i % 2;
		}

		Arrays.sort(items, new Comparator<Items>() {
			@Override
			public int compare(Items o1, Items o2) {
				return Integer.compare(o1.Position, o2.Position);
			}
		});
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < n; ++i) {
			str.append(items[i].color+ " ");
		}
		System.out.println(str);

	}

	static class Items {
		int Position;
		int value;
		int color;
	}

	static class Segment {
		int left;
		int right;
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

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
