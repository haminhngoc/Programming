import java.util.Scanner;

public class Main2299 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n;
		n = reader.nextInt();
		int[] t = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++)
		{
			t[i] = reader.nextInt();
			r[i] = reader.nextInt();
		}
		int sum = t[0];
		for (int i = 0; i < n; i++) {
			if (i != n - 1) {
				if (t[i] + t[i + 1] > r[i]) {
					sum += r[i];
					i++;
				} else {
					sum += t[i];
				}
			} else {
				sum += t[i];
			}
		}
		System.out.print(sum);

	}

}
