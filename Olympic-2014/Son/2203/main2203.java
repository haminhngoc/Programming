import java.util.Scanner;

class main2203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n;// n=10*5;
		n = reader.nextInt();
		int[] a = new int[n];
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			a[i] = reader.nextInt();
			if (i != 0) {
				a[i] += a[i - 1];
				if (a[i] < 0)
					tmp = 1;
			}
		}
		int count = 0;
		int sum = a[n - 1];
		if (tmp == 0)
			count = 1;
		for (int i = 1; i < n; i++) {
			tmp = 0;
			if (i < 0)
				break;

			else {
				for (int j = i; j < n; j++) {
					if (a[j] - a[i - 1] < 0) {
						tmp = 1;
						break;
					}
				}

				for (int j = 0; j < i; j++) {
					if (sum + a[j] < 0) {
						tmp = 1;
						break;
					}
					sum += a[j];
				}
			}
			if (tmp == 0)
				count++;
		}

		System.out.println(count);

	}
}
