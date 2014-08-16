import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class JeffandPeriods {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		List<Point> number = new ArrayList<Point>();
		Point temp;
		for (int i = 0; i < n; ++i) {
			// number[i] = new Point();
			temp = new Point();
			temp.Value = nextInt();
			temp.Position = i;
			number.add(temp);
		}

		Collections.sort(number, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.Value < o2.Value) {
					return -1;
				} else if (o1.Value > o2.Value) {
					return 1;
				}

				return Integer.compare(o1.Position, o2.Position);
			}
		});

		int p = -1;
		int count = 0;
		int x = number.get(0).Value;
		count = 1;
		int countR = 0;
		boolean check = true;
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < n; ++i) {
			p = -1;
			if (count == 1 && number.get(i).Value == number.get(i - 1).Value) {
				count = 2;
				check = true;
				p = number.get(i).Position - number.get(i - 1).Position;
				i++;
				while (i < n && number.get(i).Value == number.get(i - 1).Value) {
					if (number.get(i).Position - number.get(i - 1).Position != p) {
						check = false;
					}
					i++;
				}
				if (check) {
					result.append(x + " " + p + "\n");
					countR++;
				}
				if (i < n) {
					x = number.get(i).Value;
					count = 1;
					p = -1;
				}

			} else {
				result.append(x + " " + 0 + "\n");
				x = number.get(i).Value;
				countR++;
				count = 1;
				p = -1;
			}

		}
		if (count == 1 && p == -1) {
			countR++;
			result.append(x + " " + 0 + "\n");
		}
		System.out.println(countR);
		System.out.println(result);

	}

	static class Point {
		int Value;
		int Position;
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
