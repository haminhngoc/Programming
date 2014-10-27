import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		while (t-- > 0) {
			int cA = in.nextInt();
			int cB = in.nextInt();
			int maxA = in.nextInt();
			int maxB = in.nextInt();
			solve(cA, cB, maxA, maxB);

		}

	}

	private static void solve(long cA, long cB, long maxA, long maxB) {

		if (maxA == 0) {
			System.out.println(Math.min(maxB, cB));
			return;
		} else if (maxB == 0) {
			System.out.println(Math.min(maxA, cA));
			return;
		}

		long c1 = (cA + maxA - 1) / maxA;
		long c2 = (cB + maxB - 1) / maxB;
		if (c1 > c2) {
			if (c1 > cB) {
				System.out.println(cB
						+ ((cB + 1) * maxA > cA ? cA : (cB + 1) * maxA));
			} else {
				System.out.println(cA + cB);
			}
		} else {
			if (c2 > cA) {
				System.out.println(cA
						+ ((cA + 1) * maxB > cB ? cB : (cA + 1) * maxB));
			} else {
				System.out.println(cA + cB);
			}
		}

	}

}
