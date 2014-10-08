import java.util.Scanner;

class CBUYING_6184 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long B = scan.nextLong();
		long C[] = new long[N];
		long P[] = new long[N];
		for (int i = 0; i < N; i++) {
			P[i] = scan.nextLong();
			C[i] = scan.nextLong();
		}
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				if (P[i] > P[j]) {
					long temp = P[i];
					P[i] = P[j];
					P[j] = temp;
					temp = C[i];
					C[i] = C[j];
					C[j] = temp;
				}
		long count = 0;
		for (int i = 0; i < N; i++) {
			long plus = Check(B, P[i], C[i]);
			count += plus;
			B -= (plus * P[i]);
			if (plus < C[i])
				i = N;
		}
		System.out.println(count);
		scan.close();
	}

	private static long Check(long b, long l, long m) {
		// TODO Auto-generated method stub
		long div = b / l;
		if (div > m)
			return m;
		else
			return div;
	}

}
