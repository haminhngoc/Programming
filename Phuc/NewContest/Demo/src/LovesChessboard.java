import java.util.Scanner;

public class LovesChessboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int total = n * m;
		for (int i = 0; i < n; i++) {
			char[] c = in.next().toCharArray();
			for (int j = 0; j < m; ++j) {
				if (c[j] == '-') {
					System.out.print(c[j]);
				} else {
					char r = (i + j) % 2 == 0 ? 'W' : 'B';
					System.out.print(r);
				}
				
			}
			System.out.println();
		}
	}
}
