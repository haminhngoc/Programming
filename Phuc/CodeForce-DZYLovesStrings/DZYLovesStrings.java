import java.util.Scanner;

public class DZYLovesStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] arr = in.next().toCharArray();
		int arrLength = arr.length;
		int k = in.nextInt();
		int[] value = new int[26];
		int max = -1;
		for (int i = 0; i < 26; ++i) {
			value[i] = in.nextInt();
			if (value[i] > max) {
				max = value[i];
			}
		}
		long sum = 0;
		for (int i = 0; i < arrLength; ++i) {
			sum += (value[(int) arr[i] - 97]) * (i+1);
		}
		for (int i = arrLength; i < arrLength + k; ++i) {
			sum += (i+1) * max;
		}
		System.out.println(sum);
	}

}
