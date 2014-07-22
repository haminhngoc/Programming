import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.activation.DataSource;

public class DZYLovesSequences {

	public static void main(String[] args) throws IOException {
		DZYLovesSequences main = new DZYLovesSequences();
		main.solve();

	}

	void solve() throws IOException {
		Reader7 reader = new Reader7();
		reader.Init(System.in);
		int n = reader.NextInt();
		int[] inputs = new int[n];
		// Vector data = new Vector();
		Vector temp = new Vector();
		Vector data = new Vector();
		for (int i = 0; i < n; i++) {
			inputs[i] = reader.NextInt();
		}
		if (n == 1) {
			temp.add(inputs[0]);
			data.add(temp.toArray());
		}
		for (int i = 0; i < n - 1; i++) {
			temp.add(inputs[i]);
			if (inputs[i] < inputs[i + 1]) {
				if (i == n - 2) {
					temp.add(inputs[i + 1]);
				} else {
					continue;
				}
			}
			data.add(temp.toArray());
			temp.removeAllElements();
		}
		int size = data.size();
		int result = 0;
		Object[] datas = data.toArray();
		Object[] temp1;
		Object[] temp2;
		result = ((Object[]) datas[0]).length < n ? ((Object[]) datas[0]).length + 1
				: ((Object[]) datas[0]).length;
		for (int i = 1; i < size; i++) {
			temp1 = (Object[]) datas[i - 1];
			temp2 = (Object[]) datas[i];
			if ((temp1.length + 1) > result) {
				result = temp1.length < n ? temp1.length + 1 : temp1.length;
			}
			if ((temp2.length + 1) > result) {
				result = temp2.length < n ? temp2.length + 1 : temp2.length;
			}
			if (temp2.length > 1 && temp1.length > 1) {
				if ((int) temp2[1] - (int) temp1[temp1.length - 1] > 1
						|| (int) temp2[0] - (int) temp1[temp1.length - 2] > 1) {
					if (temp1.length + temp2.length > result) {
						result = temp1.length + temp2.length;
					}
				}
			}
		}

		System.out.print(result);
	}
}

class Reader7 {
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