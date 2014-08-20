import java.util.Scanner;

public class A2 {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		n = readers.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readers.nextInt();
		}
		int startTemp = 0, total = 0, start = 0, max = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] >= 0) {
				total++;
			} else {
				if (total > max) {
					max = total;
					start = startTemp;
				}
				startTemp = i + 1;
				total = 0;
			}
		}
		if (total > max) {
			max = total;
			start = startTemp;
		}
		System.out.print(start + "  " + max);

	}

}
