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
		ReaderMegacity reader = new ReaderMegacity();
		reader.Init(System.in);
		City temp = new City();
		int n = reader.nextInt(); // 10^3
		int s = reader.nextInt();
		int tempSum = s;
		List<City> cities = new ArrayList<City>();
		int xTemp;
		int yTemp;
		int population;
		for (int i = 0; i < n; ++i) {
			xTemp = reader.nextInt();
			yTemp = reader.nextInt();
			population = reader.nextInt();
			temp = new City();
			temp.x = xTemp;
			temp.y = yTemp;
			temp.k = population;
			tempSum += population;
			cities.add(temp);
		}
		if (tempSum < 1000000) {
			System.out.println(-1);
			return;
		}
		Collections.sort(cities, new Comparator<City>() {
			@Override
			public int compare(City o1, City o2) {
				if (o1.x * o1.x + o1.y * o1.y == o2.x * o2.x + o2.y * o2.y)
					return 0;
				if (o1.x * o1.x + o1.y * o1.y > o2.x * o2.x + o2.y * o2.y)
					return 1;
				return -1;
			}
		});
		int j = 0;
		while (s < 1000000) {
			s += cities.get(j).k;
			j++;
		}
		temp = cities.get(j - 1);
		System.out.format("%.7f%n",Math.sqrt(temp.x * temp.x + temp.y * temp.y));

	}

	static class City {
		int x;
		int y;
		int k;
	}
}

class ReaderMegacity {
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