import java.io.IOException;
import java.util.Arrays;

public class GenerateTestCases {
	public static void main(String[] args) throws IOException {
		//generate433C(10);
		generate433D();
	}
	
	public static void generate433D(){
		int n = 400;
		int m = 399;
		System.out.println(n + " " + m);
		for (int i = 0; i < n; i++) {
			char[] arr = new char[m];
			Arrays.fill(arr, '0');
			System.out.println(new String(arr));
		}
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
