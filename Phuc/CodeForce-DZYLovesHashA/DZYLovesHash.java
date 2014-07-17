import java.util.Scanner;

public class DZYLovesHash {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int n = in.nextInt();
		// long [] arr = new long[p];
		boolean[] isFilled = new boolean[p];
		for (int i = 0; i < p; ++i) {
			isFilled[i] = false;
		}
		int count = -1;
		for (int i = 0; i < n; ++i) {
			long x = in.nextLong();
			int cell = (int) (x % p);
			if ((isFilled[cell]) && count == -1) {
				count = i + 1;
			}
			isFilled[cell] = true;
		}

		System.out.println(count);

	}
}
