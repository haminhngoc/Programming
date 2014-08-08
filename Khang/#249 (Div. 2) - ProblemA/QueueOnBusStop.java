import java.util.*;

public class QueueOnBusStop {

	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt(); // 100
		int m = reader.nextInt(); // 100
		int result = 0;
		int a = 0;
		int tmp = 0;
		while (n > 0) {
			a = reader.nextInt();
			if (tmp + a <= m)
				tmp += a;
			else {
				result++;
				tmp = a;
			}
			n--;
		}
		if (tmp > 0)
			result++;

		System.out.println(result);
	}
}
