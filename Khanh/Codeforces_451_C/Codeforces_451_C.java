import java.util.Scanner;

public class Codeforces_451_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		boolean result[] = new boolean[t];
		for (int i = 0; i < t; i++) {
			long n = scan.nextLong(), k = scan.nextLong(), d1 = scan.nextLong(), d2 = scan
					.nextLong();
			if (n % 3 == 0) {
				if ((n - k) >= (d1 + d2)) {
					if ((d1 == k) && (d2 == k)) {
						if (((n - k - (d1 + d2)) % 3 == 0)
								&& ((n - k - (d1 + d2)) >= 0))
							result[i] = true;
					} else if (d1 == k) {
						if (((n - k - (2 * d1 + d2)) % 3 == 0)
								&& ((n - k - (2 * d1 + d2)) >= 0))
							result[i] = true;
					} else if (d2 == k) {
						if (((n - k - (2 * d2 + d1)) % 3 == 0)
								&& ((n - k - (2 * d2 + d1)) >= 0))
							result[i] = true;
					} else {
						if (((n - k - (2 * d1 + d2)) % 3 == 0))
							// || ((n - k - (2 * d1 + d2)) == 0))
							result[i] = true;
						if (((n - k - (2 * d2 + d1)) % 3 == 0))
							// || ((n - k - (2 * d2 + d1)) == 0))
							result[i] = true;
						if (((n - k - (d1 + d2)) % 3 == 0))
							// || ((n - k - (d1 + d2)) == 0))
							result[i] = true;
					}
				}
				if (((k > d1) && (d2 > 0)) && ((k > d2) && (d1 > 0))) {
					if (((n - k - (2 * d1 - d2)) % 3 == 0))
						result[i] = true;
					if (((n - k - (2 * d2 - d1)) % 3 == 0))
						result[i] = true;
				}
			}
			else result[i] = false;
		}
		for (int i = 0; i < t; i++)
			if (result[i] == true)
				System.out.println("yes");
			else
				System.out.println("no");

		scan.close();
	}

}
