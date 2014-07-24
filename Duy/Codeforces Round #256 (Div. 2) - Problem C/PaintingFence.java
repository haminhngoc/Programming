import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PaintingFence {

	static long s_result;

	public static void main(String[] args) throws IOException {
		PaintingFence main = new PaintingFence();
		main.solve();
	}

	void solve() throws IOException {
		ReaderPaintingFence reader = new ReaderPaintingFence();
		reader.Init(System.in);
		int n = reader.NextInt(); // 5k
		List<Long> inputs = new ArrayList<Long>();
		long input = 0;

		for (int i = 0; i < n; i++) {
			input = reader.NextLong();
			inputs.add(input);
		}
		long result = 0;
		int currentSize = inputs.size();
		result = Recur(currentSize, inputs);
		System.out.print(result);

	}

	long Recur(int currentSize, List<Long> inputs) {
		long min = Long.MAX_VALUE;
		long value = 0;
		long tempRes = 0;
		int start = 0;
		int end = 0;
		List<Long> subList = new ArrayList<Long>();

		for (int i = 0; i < currentSize; i++) {
			value = inputs.get(i);
			if (value < min) {
				min = value;
			}
		}

		tempRes += min;
		for (int i = 0; i < currentSize; i++) {
			value = inputs.get(i);
			inputs.set(i, (value - min));
		}

		for (int i = 0; i < currentSize; i++) {
			value = inputs.get(i);
			if (value == 0 || i == currentSize - 1) {
				end = i == currentSize - 1 ? currentSize : i;
				if (i == currentSize - 1 && inputs.get(end - 1) == 0) {
					end = i;
				}
				subList = inputs.subList(start, end);
				if (subList.size() > 0) {
					if (subList.size() > 1) {
						tempRes += Recur(subList.size(), subList);
					} else {
						tempRes += 1;
					}
				}
				start = i + 1;
			}
		}
		if (tempRes >= currentSize) {
			s_result = currentSize;
		} else {
			s_result = tempRes;
		}
		return s_result;
	}
}

class ReaderPaintingFence {
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