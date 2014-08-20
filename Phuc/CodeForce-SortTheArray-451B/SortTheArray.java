import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortTheArray {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int[] arr = new int[n];
		int count = 0;
		boolean isDesceding = false;
		int pre = Integer.MIN_VALUE;
		boolean checkPosibility = true;
		int start = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = nextInt();
		}

		int end = -1;
		for (int i = 0; i < n; ++i) {
			if (checkPosibility) {
				if (!isDesceding) {
					if (arr[i] < pre) {
						count++;
						isDesceding = true;
						start = i - 1;
					}
				} else {
					if (arr[i] > pre) {
						end = i - 1;
						isDesceding = false;
						if (arr[start] > arr[i]) {
							checkPosibility = false;
						}
						if (start - 1 >= 0 && arr[start-1] > arr[end]) {
							checkPosibility = false;
						}
					}
				}
				pre = arr[i];
			}
		}

		if (isDesceding) {
			end = n - 1;
			isDesceding  = false;
			if (start - 1 >= 0 && arr[start-1] > arr[end]) {
				checkPosibility = false;
			}
		}

		if (count == 1) {
			if (checkPosibility) {
				System.out.println("yes");
				start++;
				end++;
				if (isDesceding) {
					System.out.println(start + " " + n);
				} else {
					System.out.println(start + " " + end);
				}
			} else {
				System.out.println("no");
			}
		} else if (count > 1) {
			System.out.println("no");
		} else {
			System.out.println("yes\n1 1");
		}

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

}
