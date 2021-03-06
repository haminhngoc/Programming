import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int left = in.nextInt();
		int right = in.nextInt();
		solve(left, right);
	}

	private static void solve(int left, int right) {
		int count = 0;
		long arr[] = new long[right+1];
		Arrays.fill(arr, 1);
		int end = (int) Math.sqrt(right);
		for (int i = 2; i <= end; ++i) {
			for (int j = i; i * j <= right; ++j) {
				arr[i * j] += i;
				if (j != i) {
					arr[i * j] += j;
				}
			}
		}

		for (int i = left; i <= right; ++i) {
			if (arr[i] > i) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean check(int i) {
		long r = 0;
		int end = (int) Math.sqrt(i);

		return false;
	}
}
