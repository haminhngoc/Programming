import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		long sum = 0;
		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp = in.nextInt();
			sum += temp;
		}
		long current = sum + 10 * (n - 1);
		if (d < current) {
			System.out.println(-1);
		} else {
			int count = 2 * n - 2;
			count += (d - current) / 5;
			System.out.println(count);
		}

	}

}
