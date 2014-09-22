import java.util.*;

public class A7 {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int k1 = reader.nextInt();
		int k2 = reader.nextInt();
		int n = reader.nextInt();
		int[] array = new int[n];
		int end = 0;
		int maxLength = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		int max = array[0];
		for (int i = 0; i < n; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			count++;
			if (array[i] <= k1 || array[i] >= k2) {
				if (count > maxLength) {
					maxLength = count - 1;
					end = i - 1;
				}
				max = Integer.MIN_VALUE;
				count = 0;
			} else {
				if (count > maxLength) {
					maxLength = count;
				}
				end = i;
			}

		}
		if (maxLength == 0)
			System.out.println("Not found");
		else {
			System.out.println((end - maxLength + 2) + " " + (end + 1));
			System.out.println(maxLength);
		}
	}

}
