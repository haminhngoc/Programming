import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		in = new FileInputStream("text.txt");
		PrintWriter w = new PrintWriter("out.txt");
		int n = nextInt();
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < n; ++i) {
			list.add(new T(nextInt(), i, n));
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {

				if (i != j) {
					list.add(new T(nextInt(), i, j));
				} else {
					int t = nextInt();
				}
			}
		}
		UnionSet set = new UnionSet(n + 1);
		Collections.sort(list);
		int size = list.size();
		long result = 0;
		int count = 0;
		for (int i = 0; i < size; ++i) {
			if (!set.isSameSet(list.get(i).p1, list.get(i).p2)) {
				result += list.get(i).cost;
				set.unionSet(list.get(i).p1, list.get(i).p2);
				count++;
			}
			if (count == n) {
				break;
			}
		}

		System.out.println(result);
		int r = (int) result;
		w.print(r);;
		w.close();

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

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	private static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);

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

class T implements Comparable<T> {
	int cost;
	int p1;
	int p2;

	public T(int c, int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.cost = c;
	}

	@Override
	public int compareTo(T arg0) {
		if (cost < arg0.cost) {
			return -1;
		}
		if (cost == arg0.cost) {
			return 0;
		}
		return 1;
	}
}

class UnionSet {
	int[] pset;

	public UnionSet(int n) {
		pset = new int[n];

		for (int i = 0; i < n; ++i) {
			pset[i] = i;
		}

	}

	int findSet(int i) {
		if (pset[i] == i) {
			return i;
		}
		return pset[i] = findSet(pset[i]);
	}

	void unionSet(int i, int j) {
		pset[findSet(i)] = findSet(j);
	}

	boolean isSameSet(int p1, int p2) {
		return findSet(p1) == findSet(p2);
	}
}
