import java.util.Scanner;

public class A1 {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		n = readers.nextInt();
		int[] array = new int[n];
		int startTemp = 0, index = 0, total = 1, max = 0, start = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readers.nextInt();
		}
		for (int i = 1; i < n; i++) {
			if (array[i] >= array[i - 1]) {
				total++;
				if (i == n - 1)
					if (total > max) {
						max = total;
						start = startTemp;
					}
			} else {
				if (total > max) {
					max = total;
					start = startTemp;
					startTemp = i;
					total = 1;
				}
			}
		}
		System.out.print(start+"  "+max);

	}

}
