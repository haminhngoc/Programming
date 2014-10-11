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
		StringBuilder result = new StringBuilder();
		do {
			result.insert(0,((char)(k % 2 + 48)));
			k /= 2;
		} while (k > 0);
		System.out.println(result);	
	}
}