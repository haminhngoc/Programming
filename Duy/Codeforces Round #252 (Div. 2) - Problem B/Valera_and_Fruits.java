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
import java.util.Vector;

public class Valera_and_Fruits {

	public static void main(String[] args) throws IOException {
		Valera_and_Fruits main = new Valera_and_Fruits();
		main.solve();

	}


	
	void solve() throws IOException {
		Reader2 reader = new Reader2();
		reader.Init(System.in);
		int result = 0;
		int numberOfFruitTrees = reader.NextInt();
		int nCanCollect = reader.NextInt();
		List<FruitTree> fruitTrees = new ArrayList<FruitTree>();
		FruitTree fruitTree;
		int numberOfDays = 0;
		int numberOfFruits = 0;
		
		for (int i = 0; i < numberOfFruitTrees; i++) {
			numberOfDays = reader.NextInt();
			numberOfFruits = reader.NextInt();
			fruitTree = new FruitTree(numberOfDays, numberOfFruits);
			fruitTrees.add(fruitTree);
		}

		Collections.sort(fruitTrees, new Comparator<FruitTree>() {
			@Override
			public int compare(FruitTree c1, FruitTree c2) {
				return Integer.compare(c1.numberOfDays, c2.numberOfDays);
			}
		});

		int n = numberOfFruitTrees;
		for (int i = 0; i < n - 1; i++) {
			if (fruitTrees.get(i).numberOfDays == fruitTrees.get(i + 1).numberOfDays) {
				fruitTrees.get(i).numberOfFruits += fruitTrees.get(i + 1).numberOfFruits;
				fruitTrees.remove(i + 1);
				n--;
				i--;
			}
		}
		
		int temp = 0;
		n = fruitTrees.size();
		for (int i = 0; i < n; i++) {
			temp = nCanCollect;
			if (i > 0) {
				if (fruitTrees.get(i - 1).numberOfFruits >= temp) {
					result += temp;
					fruitTrees.get(i - 1).numberOfFruits -= temp;
					temp = 0;
				} else {
					result += fruitTrees.get(i - 1).numberOfFruits;				
					temp -= fruitTrees.get(i - 1).numberOfFruits;
					fruitTrees.get(i - 1).numberOfFruits = 0;
				}
				if (fruitTrees.get(i).numberOfDays
						- fruitTrees.get(i - 1).numberOfDays > 1) {
					temp = nCanCollect;
				}

			}
			if (temp > 0) {
				if (fruitTrees.get(i).numberOfFruits >= temp) {
					result += temp;
					fruitTrees.get(i).numberOfFruits -= temp;
				} else {
					result += fruitTrees.get(i).numberOfFruits;				
					fruitTrees.get(i).numberOfFruits = 0;
				}
			}

		}
		if (fruitTrees.get(n - 1).numberOfFruits >= nCanCollect) {
			result += nCanCollect;
		} else {
			result += fruitTrees.get(n - 1).numberOfFruits;
		}
		System.out.print(result);
	}
}

class FruitTree {
	int numberOfDays;
	int numberOfFruits;

	public FruitTree(int numbOfDays, int numbOfFruits) {
		numberOfDays = numbOfDays;
		numberOfFruits = numbOfFruits;
	}
}

class Reader2 {
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