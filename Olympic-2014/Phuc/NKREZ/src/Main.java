import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		Room[] rooms = new Room[n];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			rooms[i] = new Room();
			rooms[i].p = nextInt();
			rooms[i].k = nextInt();
			if (rooms[i].k > max) {
				max = rooms[i].k;
			}
		}

		Arrays.sort(rooms);

		int arr[] = new int[max + 1];
		int index = 0;
		for (int i = 0; i < n; ++i) {
			while (index < rooms[i].p) {
				index++;
				arr[index] = Math.max(arr[index - 1], arr[index]);
			}

			if (arr[index] + rooms[i].k - rooms[i].p > arr[rooms[i].k]) {
				arr[rooms[i].k] = arr[index] + rooms[i].k - rooms[i].p;
			}
		}
		int j = 0;
		for (int i = 1; i <= max; ++i) {
			if (arr[i] > arr[j]) {
				j = i;
			}
		}
		System.out.println(arr[j]);
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

class Room implements Comparable<Room> {
	public int p;
	public int k;

//	@Override
	public int compareTo(Room a) {
		if (this.p < a.p) {
			return -1;
		} else if (this.p > a.p) {
			return 1;
		}
		return this.k - a.k;
	}
}