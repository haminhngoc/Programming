import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		char[][] input = new char[T][];
		for (int i = 0; i < T; i++) {
			char[] inputi = input[i] = sc.next().toCharArray();
			int len = inputi.length;
			int len2 = len / 2;
			for (int j = 0; j < len2; j++) {
				char temp = inputi[j];
				inputi[j] = inputi[len - 1 - j];
				inputi[len - 1 - j] = temp;
			}
			System.out.println(inputi);
		}

	}
}
