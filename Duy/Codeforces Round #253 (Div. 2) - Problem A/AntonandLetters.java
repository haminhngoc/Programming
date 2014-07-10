import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AntonandLetters {

	public static void main(String[] args) throws IOException {
		AntonandLetters main = new AntonandLetters();
		main.SolveProblem();
	}

	void SolveProblem() throws IOException {
		Reader reader = new Reader();
		reader.Init(System.in);
		String input = reader.Next1();
		if(input.equalsIgnoreCase(""))
		{
			System.out.print(0);
			return;
		}
		char[] inputs = input.toCharArray();
		Arrays.sort(inputs);
		int result = 0;

		for (int i = 0; i < inputs.length - 1; i++) {
			if (inputs[i] == inputs[i + 1]) {
				continue;
			}
			result++;
		}
			result++;
		System.out.print(result);
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

	static String Next1() throws IOException {
		String result = reader.readLine();
		result = result.replaceAll("[}{, ]", "");
		return result;
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}
