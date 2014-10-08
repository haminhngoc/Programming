import java.util.*;

class BASEH {

	public static void main(String[] args) {
		BASEHSolver solver = new BASEHSolver();
		solver.solve();

	}

}

class BASEHSolver {
	
	private static Scanner in = new Scanner(System.in);
	public void solve() {
		int k = in.nextInt();
		int h = in.nextInt();
		int a[] = new int[10];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i < 10; i++) {			
			if (i % 2 == 0) {
				a[i] = h * a[i/2];				
			} else {
				a[i] = h * a[(i - 1)/2] + 1;
			}
			System.out.println(i + ": "+ a[i]);
		}
	}
}