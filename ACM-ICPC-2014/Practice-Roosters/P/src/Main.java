public class Main {

	public static void main(String[] args) {
		int a = 20;
		for (int i = 1; i <= a; ++i) {
			for (int j = 1; j <= i; ++j)
				if (gcd(j, i) == (j ^ i)) {
					System.out.println(i + " " + j + " " + (j ^ i));
				}
		}
	}

	private static int gcd(int a, int i) {

		if (a % i == 0) {
			return i;
		}
		return gcd(i, a % i);
	}

}
