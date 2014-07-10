import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class DZYLovesChemistry {

	public static void main(String[] args) throws IOException {
		DZYLovesChemistry main = new DZYLovesChemistry();
		main.solve();
	}

	static int numbOfConnectedComponents = 0;
	static int[] labels;
	static int n = 0;

	int FindConnectedComponents(int[][] inputs, int n) {
		labels = new int[n];
		int pow = 0;
		for (int i = 0; i < n; i++) {
			labels[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			if (labels[i] == 0) {
				numbOfConnectedComponents++;
				Visit(i, inputs, numbOfConnectedComponents);
			}
		}
		int temp = 0;
		Arrays.sort(labels);
		for (int i = 0; i < n - 1; i++) {

			if (labels[i] == labels[i + 1]) {
				temp++;			
			} 
		}
		return temp;

	}

	void Visit(int i, int[][] inputs, int numbOfConnectedComponents) {
		labels[i] = numbOfConnectedComponents;
		for (int j = 0; j < n; j++) {
			if (labels[j] == 0 && inputs[i][j] != 0) {
				Visit(j, inputs, numbOfConnectedComponents);
			}
		}
	}

	void solve() throws IOException {
		Reader reader = new Reader();
		int firstChemical = 0;
		int secondChemical = 0;
		reader.Init(System.in);
		n = reader.NextInt();
		int m = reader.NextInt();
		Vector temp = new Vector();
		int[][] inputs = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				inputs[i][j] = 0;
			}
		}
		for (int i = 0; i < m; i++) {
			firstChemical = reader.NextInt();
			secondChemical = reader.NextInt();
			inputs[firstChemical - 1][secondChemical - 1] = 1;
			inputs[secondChemical - 1][firstChemical - 1] = 1;
		}
		/*
		 * for (int i = 0; i < n; i++) { for (int j = i+1; j < n; j++) { if
		 * (inputs[i][j] == 1) System.out.println((i + 1) + " " + (j + 1)); } }
		 */
		int pow = FindConnectedComponents(inputs, n);
		System.out.print((long) (Math.pow(2, pow)));
	}

}

class Reader {
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