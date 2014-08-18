import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bombs {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		List<Point> one = new ArrayList<Point>();
		List<Point> two = new ArrayList<Point>();
		List<Point> three = new ArrayList<Point>();
		List<Point> four = new ArrayList<Point>();
		Point temp;
		for (int i = 0; i < n; ++i) {
			temp = new Point();
			temp.x = nextInt();
			temp.y = nextInt();
			if (temp.x >= 0 && temp.y >= 0) {
				one.add(temp);
			} else if (temp.x >= 0) {
				two.add(temp);
			} else if (temp.y >= 0) {
				four.add(temp);
			} else {
				three.add(temp);
			}
		}

		int result = 0;
		StringBuilder operations = new StringBuilder();
		Collections.sort(one, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x) {
					return -1;
				} else if (o1.x > o2.x) {
					return 1;
				}
				return Integer.compare(o1.y, o2.y);
			}
		});

		int size = one.size();
		int right;
		int left;
		int up;
		int down;
		for (int i = 0; i < size; ++i) {
			right = one.get(i).x;
			if (right > 0) {
				operations.append("1 " + right + " R\n");
				result++;
			}
			up = one.get(i).y;
			if (up > 0) {
				operations.append("1 " + up + " U\n");
				result++;
			}
			operations.append(2 + "\n");

			if (up > 0) {
				operations.append("1 " + up + " D\n");
				result++;
			}
			if (right > 0) {
				operations.append("1 " + right + " L\n");
				result++;
			}
			operations.append(3 + "\n");
			result += 2;
		}

		Collections.sort(two, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x) {
					return -1;
				} else if (o1.x > o2.x) {
					return 1;
				}
				return Integer.compare(o2.y, o1.y);
			}
		});
		size = two.size();
		for (int i = 0; i < size; ++i) {
			right = two.get(i).x;
			if (right > 0) {
				operations.append("1 " + right + " R\n");
				result++;
			}
			down = -two.get(i).y;
			if (down > 0) {
				operations.append("1 " + down + " D\n");
				result++;
			}
			operations.append(2 + "\n");

			if (down > 0) {
				operations.append("1 " + down + " U\n");
				result++;
			}
			if (right > 0) {
				operations.append("1 " + right + " L\n");
				result++;
			}
			operations.append(3 + "\n");
			result += 2;
		}

		Collections.sort(four, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o2.x < o1.x) {
					return -1;
				} else if (o2.x > o1.x) {
					return 1;
				}
				return Integer.compare(o1.y, o2.y);
			}
		});
		size = four.size();
		for (int i = 0; i < size; ++i) {
			right = -four.get(i).x;
			if (right > 0) {
				operations.append("1 " + right + " L\n");
				result++;
			}
			down = four.get(i).y;
			if (down > 0) {
				operations.append("1 " + down + " U\n");
				result++;
			}
			operations.append(2 + "\n");

			if (down > 0) {
				operations.append("1 " + down + " D\n");
				result++;
			}
			if (right > 0) {
				operations.append("1 " + right + " R\n");
				result++;
			}
			operations.append(3 + "\n");
			result += 2;
		}
		Collections.sort(three, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o2.x < o1.x) {
					return -1;
				} else if (o2.x > o1.x) {
					return 1;
				}
				return Integer.compare(o2.y, o1.y);
			}
		});
		size = three.size();
		for (int i = 0; i < size; ++i) {
			right = -three.get(i).x;
			if (right > 0) {
				operations.append("1 " + right + " L\n");
				result++;
			}
			down = -three.get(i).y;
			if (down > 0) {
				operations.append("1 " + down + " D\n");
				result++;
			}
			operations.append(2 + "\n");

			if (down > 0) {
				operations.append("1 " + down + " U\n");
				result++;
			}
			if (right > 0) {
				operations.append("1 " + right + " R\n");
				result++;
			}
			operations.append(3 + "\n");
			result += 2;
		}

		System.out.println(result);
		System.out.println(operations);

	}

	static class Point {
		int x;
		int y;
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
