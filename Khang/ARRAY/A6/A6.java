import java.util.*;

public class A6 {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		int start = 0, end = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		int max = array[0];
		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				if (array[i] > sum + array[i]) {
					sum = array[i];
					}
				else
					sum += array[i];
				if (sum > max) {
					max = sum;
					end = i;
				}
			} else {
				if (sum + array[i] > max) {
					sum += array[i];
					max = sum;
					end = i;
				} else {
					sum = 0;
				}
			}
		}
		System.out.println((start + 1) + " " + (end + 1));
		System.out.println(max);
	}

}
