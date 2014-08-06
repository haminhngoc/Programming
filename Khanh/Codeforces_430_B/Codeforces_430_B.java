import java.util.Scanner;

public class Codeforces_430_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt(), x = scan.nextInt();
		int[] a = new int[n + 2];
		a[0] = -1;
		a[n] = -1;
		for (int i = 1; i < n + 1; i++)
			a[i] = scan.nextInt();
		int max = 0, maxI = 0;
		for (int i = 1; i < n + 1; i++)
			if (a[i] == a[i + 1]) {
				if (a[i] == x) {
					int dX = 2 + destroy(a, n, i, i + 1);
					if (max < dX) {
						max = dX;
						maxI = i;
					}
				}
			}
		System.out.println(max);
		//System.out.println(max + " " + maxI);
		scan.close();
	}

	private static int destroy(int[] a, int n, int l, int r) {
		// TODO Auto-generated method stub
		int nBalls = 0;
		if ((l > 0) && (r < n + 1)) {
			if (a[l - 1] == a[r + 1]) {
				if ((a[l - 2] == a[l - 1]) && (a[r + 1] == a[r + 2])) {
					nBalls += 4 + destroy(a, n, l - 2, r + 2);
				} else if (a[l - 2] == a[l - 1])
					nBalls += 3 + destroy(a, n, l - 2, r + 1);
				else if (a[r + 1] == a[r + 2])
					nBalls += 3 + destroy(a, n, l - 1, r + 2);
			}
		}
		return nBalls;
	}

}
