import java.util.Scanner;

class VMREL6_20645 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int iTMin = 0;
		int a[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			int temp = 1;
			for (int j = 0; j < N; j++) {
				a[i][j] = scan.nextInt();
				if (a[i][j] < 0)
					temp = 0;
			}
			if (temp == 1)
				iTMin = i;
		}

		int T[] = new int[N];
		for (int i = 0; i < N; i++)
			T[i] = 1;

		int max = 1;
		for (int i = 0; i < N; i++) {
			if (i != iTMin)
				for (int j = 0; j < N; j++) {
					int x = a[i][j];
					if (x == -1 && T[i]<=T[j])
						T[i]++;
					if (T[j] > max)
						max = T[j];
				}
		}
		System.out.println(max);
		for (int i = 0; i < N; i++)
			System.out.print(T[i]+" ");
		scan.close();
	}

}
