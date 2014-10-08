import java.util.*;

class C11SEQ3 {

	public static void main(String[] args) {
		C11SEQ3Solver solver = new C11SEQ3Solver();
		solver.solve();

	}

}

class C11SEQ3Solver {
	private static Scanner in = new Scanner(System.in);
	private final int[] CONS_ARR = new int[] { 0, 1, 2, 4, 8, 16, 23, 46, 29,
			58, 116, 223, 446, 289, 578, 1156, 1223, 2446, 2489, 4789, 5789,
			11578, 12356, 12247, 24449, 48889, 77789, 155578 };

	public void solve() {
		int n = in.nextInt();
		if (n <= 27) {
			System.out.println(CONS_ARR[n]);
			return;
		}
		//printF(n);
		switch (n % 6) {
			case 4:
				System.out.println(111356);
				return;
			case 5:
				System.out.println(122227);
				return;
			case 0:
				System.out.println(244445);
				return;
			case 1:
				System.out.println(48889);
				return;
			case 2:
				System.out.println(77789);
				return;
			case 3:
				System.out.println(155578);
				return;
		}		
	}

	private static void printF(int n) {
		int[] F = new int[n];
		F[0] = 1;
		for (int i = 1; i < n; i++) {
			F[i] = Integer.parseInt(convert(F[i - 1] * 2));
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (i > 26) {
				System.out.print(i + 1 + ":" + F[i] + " ");
				count++;
				if (count % 6 == 0) {
					count = 0;
					System.out.println();
				}
			}			
		}
	}

	private static String convert(int n) {
		StringBuilder tmp = new StringBuilder();
		while (n > 0) {
			if (n % 10 != 0) {
				tmp.append((n % 10));
			}
			n /= 10;
		}
		char[] result = tmp.toString().toCharArray();
		Arrays.sort(result);
		return new String(result);
	}
}
