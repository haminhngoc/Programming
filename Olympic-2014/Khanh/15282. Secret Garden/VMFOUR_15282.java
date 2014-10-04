import java.util.Scanner;

class VMFOUR_15282 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n + 1];
		int pos[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
			pos[arr[i]] = i;
		}
		int i, j, p, q;
		int ai, aj, ap, aq;
		int r = 0;
		for (i = 1; i < n - 2; i++) {
			ai = arr[i];
			if (2 < ai && ai < n)
				for (ap = ai + 1; ap <= n; ap++) {
					p = pos[ap];
					if (p > i + 1 && p < n) {
						for (q = p + 1; q <= n; q++) {
							aq = arr[q];
							if (aq > 1 && aq < ai) {
								for (aj = aq - 1; aj >= 1; aj--) {
									j = pos[aj];
									if (i < j && j < p) {
										r++;
										/*System.out.println(i + " " + j + " "
												+ p + " " + q);*/
									}
								}
							}
						}
					}
				}
		}
		System.out.print(r);
		scan.close();
	}
}
