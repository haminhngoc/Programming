import java.util.Scanner;


class VOSRTRI {

	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		int n;// n=100000;
		n = reader.nextInt();

		long[] x = new long[100001];
		long[] y = new long[100001];
		int[] X = new int[n];
		int[] Y = new int[n];
		for (int i = 0; i < n; i++) {
			X[i] = reader.nextInt();
			Y[i] = reader.nextInt();
			x[X[i]]++;
			y[Y[i]]++;
		}
		long count = 0;
		for (int i = 0; i < n; i++) {
			if (x[X[i]] > 1 && y[Y[i]] > 1)
				count += (x[X[i]] - 1) * (y[Y[i]] - 1);
		}

		System.out.println(count);
	}
}
