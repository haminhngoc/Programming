import java.util.Scanner;
import java.util.Scanner;

public class JzzhuandChocolate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long m = in.nextInt();
		long k = in.nextLong();
		if (k > n + m - 2) {
			System.out.println(-1);
			return;
		}
		long min = m < n ? m : n;
		long max = m < n ? n : m;
		long result;
		if (k >= max - 1) {
			result = min / (k - max + 2);
		}
		else if (k > min - 1) {
			result = ((long) (max / (k + 1))) * min;
		} else {
			long s1 = ((long) (max / (k + 1))) * min;
			long s2 = ((long) (min / (k + 1))) * max;
			result = s1 > s2 ? s1 : s2;
		}
		System.out.println(result);

	}
}
