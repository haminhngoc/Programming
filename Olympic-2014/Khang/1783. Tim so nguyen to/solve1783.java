import java.util.*;

class solve1783 {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int a = reader.nextInt();
		int b = reader.nextInt();
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}	
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
