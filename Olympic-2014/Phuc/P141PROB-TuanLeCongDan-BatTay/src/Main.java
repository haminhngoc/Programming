import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		int c = in.nextInt();

		char[][] matrix = new char[r][c];
		in.nextLine();
		for (int i = 0; i < r; ++i) {
			matrix[i] = in.nextLine().toCharArray();
		}

		int max = 0;
		int pre = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (matrix[i][j] == '.') {
					int temp = 0;

					if (i != 0) {
						temp += matrix[i - 1][j] == 'o' ? 1 : 0;
						if (j > 0) {
							temp += (matrix[i - 1][j - 1] == 'o') ? 1 : 0;
						}
						if (j < c - 1) {
							temp += (matrix[i - 1][j + 1] == 'o') ? 1 : 0;
						}

					}

					if (i != r - 1) {
						temp += matrix[i + 1][j] == 'o' ? 1 : 0;
						if (j > 0) {
							temp += (matrix[i + 1][j - 1] == 'o') ? 1 : 0;
						}
						if (j < c - 1) {
							temp += matrix[i + 1][j + 1] == 'o' ? 1 : 0;
						}

					}

					if (j != 0) {
						temp += matrix[i][j - 1] == 'o' ? 1 : 0;
					}

					if (j != c - 1) {
						temp += matrix[i][j + 1] == 'o' ? 1 : 0;
					}
					max = Math.max(max, temp);

				} else {

					if (i != 0) {
						pre += matrix[i - 1][j] == 'o' ? 1 : 0;
						if (j > 0) {
							pre += (matrix[i - 1][j - 1] == 'o') ? 1 : 0;
						}
						if (j < c - 1) {
							pre += (matrix[i - 1][j + 1] == 'o') ? 1 : 0;
						}

					}

					if (i != r - 1) {
						pre += matrix[i + 1][j] == 'o' ? 1 : 0;
						if (j > 0) {
							pre += (matrix[i + 1][j - 1] == 'o') ? 1 : 0;
						}
						if (j < c - 1) {
							pre += matrix[i + 1][j + 1] == 'o' ? 1 : 0;
						}

					}

					if (j != 0) {
						pre += matrix[i][j - 1] == 'o' ? 1 : 0;
					}

					if (j != c - 1) {
						pre += matrix[i][j + 1] == 'o' ? 1 : 0;
					}
				}
			}
		}

		System.out.println(max + pre / 2);
	}
}
