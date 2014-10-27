import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class Main {
	static List<Integer>[] graph;
	static int count[];
	static boolean visited[];

	public static void main(String[] args) {
		int k = nextInt();
		int n = nextInt();
		int m = nextInt();
		int[] people = new int[k];
		for (int i = 0; i < k; ++i) {
			people[i] = nextInt();
		}

		graph = new List[n + 1];
		for (int i = 0; i <= n; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; ++i) {
			int t = nextInt();
			int p = nextInt();
			graph[t].add(p);
		}
		count = new int[n + 1];
		for (int i = 0; i < k; ++i) {
			visited = new boolean[n + 1];
			visited[people[i]] = true;
			count[people[i]]++;
			dfs(people[i]);
		}

		long countR = 0;
		for (int i = 0; i <= n; ++i) {
			if (count[i] == k) {
				countR++;
			}
		}
		
		System.out.println(countR);

	}

	private static void dfs(int current) {
		int l = graph[current].size();
		for (int i = 0; i < l; ++i) {
			int nextR = graph[current].get(i);
			if (!visited[nextR]) {
				visited[nextR] = true;
				count[nextR]++;
				dfs(nextR);
			}
		}

	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static int readByte() {

		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return -1;
			}

		}

		return bytes[ptrbuf++];
	}

	public static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);
	}

	public static String nextString2() {
		StringBuilder str = new StringBuilder();

		int b;
		while ((b = readByte()) != -1 && isSpace(b) && b != ' ')
			;
		while (!isSpace(b) || b == ' ') {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	public static char nextChar() {
		return (char) read();
	}

	public static String nextString() {
		StringBuilder str = new StringBuilder();

		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
	}

	public static int nextInt() {
		return Integer.parseInt(nextString());
	}

	public static long nextLong() {
		return Long.parseLong(nextString());
	}

}
