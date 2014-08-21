import java.util.Scanner;

public class A2 {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		int start = 0, end = 0;
		int maxLength = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
			if (array[i] >= 0) {
				count++;
			} else {
				if (maxLength < count) {
					end = i > 0 ? i - 1 : i;
					start = end - count + 1;
					maxLength = count;
					count = 0;
				}
			}
			if (i == n - 1) {
				if (maxLength < count) {
					end = i > 0 ? i - 1 : i;
					start = end - count + 1;
					maxLength = count;
				}
			}
		}
		if (maxLength > 0)
			System.out.println((start + 1) + " " + (end + 1) + " " + maxLength);
		else
			System.out.println("not found!");
	}

}
