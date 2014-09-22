import java.util.*;

public class A1 {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		int start = 0, end = 0;
		int maxLength = 1;
		int count = 0;
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
			if (i > 0) {
				if (array[i] >= array[i - 1]) {
					count++;
				} else {
					if (maxLength < count) {
						end = i - 1;
						start = end - count;
						maxLength = count + 1;
						count = 0;
					}
				}
				if (i == n - 1) {
					if (maxLength < count) {
						end = i;
						start = end - count;
						maxLength = count + 1;					
					}
				}
			}
		}
		System.out.println((start+1) + " " + (end+1) + " " + maxLength);
	}

}
