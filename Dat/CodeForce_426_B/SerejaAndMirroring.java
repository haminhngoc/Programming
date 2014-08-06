import java.util.*;

public class SerejaAndMirroring {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n, m;
		n = readers.nextInt();
		m = readers.nextInt();
		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = readers.nextInt();
			}
		}
		boolean isTrue=true;
		int row = n;
		int minimum = row;
		while (isTrue) {
			if (row % 2 == 0) {
				row=row/2;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < m; j++) {
						if (array[i][j] != array[row*2 - i - 1][j]) {
							System.out.print(row*2);
							i=row;
							j=m;
							isTrue=false;
						}
					}
				}
				
			}
			else {
				System.out.print(row);
				break;
			}

		}

	}

}
