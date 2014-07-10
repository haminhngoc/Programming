import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TandemRepeat {

	public static void main(String[] args) throws IOException {
		TandemRepeat solve = new TandemRepeat();
		solve.SolveProblem();
	}

	void SolveProblem() throws IOException {
		Reader reader = new Reader();
		reader.Init(System.in);
		String inputStr = reader.Next();
		int k = reader.NextInt();
		int positionStringAfter = 0;
		int lengthOfS = inputStr.length();
		int maxLength = 0;
		String before = "";
		String after = "";

		for (int i = 0; i < lengthOfS - 1; i++) {
			for (int j = i + 1; j < lengthOfS; j++) {
				if (inputStr.charAt(j) == inputStr.charAt(i)) {
					if((j-i)*2 + i > lengthOfS)
					{
						continue;
					}
					before = inputStr.substring(i, j);
					after = inputStr.substring(j, (j-i)*2 + i);
					if (before.equalsIgnoreCase(after) == true) {
						if (maxLength < (j - i) * 2) {
							maxLength = (j - i) * 2;
						}
					}
				}
			}
		}

		for (int i = 0; i < lengthOfS; i++) {
			if (((lengthOfS - i) + k) % 2 != 0) {
				continue;
			}
			positionStringAfter = ((lengthOfS + i) + k) / 2;
			int tempLength = (lengthOfS - i) + k;
			int tempPosition = lengthOfS - positionStringAfter;
			if (tempPosition > 0) {
				for (int j = 0; j < tempPosition; j++) {
					if (inputStr.charAt(i + j) != inputStr
							.charAt(positionStringAfter + j)) {
						break;
					}
					if (j == tempPosition - 1 && tempLength > maxLength) {
						maxLength = tempLength;
						break;
					}
				}
			} else {
				if (tempLength > maxLength) {
					maxLength = tempLength;
				}
			}
		}
		System.out.print(maxLength);
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

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}