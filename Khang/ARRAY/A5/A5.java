import java.util.*;

public class A5 {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		int start = 0, end = 0;
		int difference = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		if (n == 1)
		{
			System.out.println("Not found");
			return;
		}
		for (int i = 1; i < n; i++) {
			if (array[i - 1] < min) {
				min = array[i - 1];
				start = i - 1;
			}
			difference = array[i] - min;
			if (difference > max) {
				max = difference;
				end = i;
			}
		}
		System.out.println(start + " " + end);
		System.out.println(max);
	}

}
