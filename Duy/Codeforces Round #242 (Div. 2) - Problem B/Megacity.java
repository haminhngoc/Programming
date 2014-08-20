import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Megacity {

	public static void main(String[] args) throws IOException {
		Megacity main = new Megacity();
		main.solve();
	}

	void solve() throws IOException {
		ReaderMegacity reader = new ReaderMegacity();
		reader.Init(System.in);
		int n = reader.NextInt();
		int s = reader.NextInt();
		List<City> inputs = new ArrayList<City>();
		City city;
		int x;
		int y;
		int si;
		for (int i = 0; i < n; i++) {
			x = reader.NextInt();
			y = reader.NextInt();
			si = reader.NextInt();
			city = new City(Math.sqrt(x * x + y * y), si);
			inputs.add(city);
		}
		Collections.sort(inputs, new Comparator<City>() {
			@Override
			public int compare(City o1, City o2) {
				return Double.compare(o1.r, o2.r);
			}
		});
		int length = inputs.size();
		for (int i = 0; i < length; i++) {
			s += inputs.get(i).si;
			if (s >= 1000000) {
				System.out.print(inputs.get(i).r);
				return;
			}
		}
		System.out.print(-1);
	}
}

class City {
	double r;
	int si;

	public City(double radius, int s) {
		r = radius;
		si = s;
	}
}

class ReaderMegacity {
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