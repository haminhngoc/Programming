import java.io.IOException;

public class GenerateTestCases {
	public static void main(String[] args) throws IOException {
		generate433C(10);
	}

	public static void generate433C(int number) {

		for (int i = 0; i < number; i++) {
			int n = random(10, 100);
			int m = random(10, 100);
			System.out.println(n + " " + m);
			for (int j = 0; j < m; j++) {
				System.out.print(random(1, n) + " ");
			}
			System.out.println("");
		}

	}

	/*****************************************************************
	 *********************** UTILITIES *******************************
	 *****************************************************************/

	public static int random(int from, int to) {
		if (from > to) {
			int temp = from;
			from = to;
			to = temp;
		} else if (from == to) {
			to++;
		}
		return (int) (Math.floor(Math.random() * Integer.MAX_VALUE
				% (to - from)) + from);
	}
}
