import java.util.Arrays;

public class MatrixAlgorithms {

	// Input: boolean matrix(m, n)
	// true: Can jump in
	// false: Can not jump in
	static int[][] findMinPath(boolean[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int size = row * column;

		int[][] tracker = new int[row][column];
		int[] queueRow = new int[size];
		int[] queueColumn = new int[size];

		for (int i = 0; i < row; i++) {
			Arrays.fill(tracker[i], Integer.MAX_VALUE);
		}
		Arrays.fill(queueRow, -1);
		Arrays.fill(queueColumn, -1);

		tracker[0][0] = 0;
		queueRow[0] = 0;
		queueColumn[0] = 0;
		int head = 0;
		int tail = 0;

		while (head <= tail) {
			int r = queueRow[head];
			int c = queueColumn[head];
			int headValue = tracker[r][c];

			if (r > 0) {
				if (matrix[r - 1][c] && tracker[r - 1][c] > headValue + 1) {
					tail++;
					queueRow[tail] = r - 1;
					queueColumn[tail] = c;
					tracker[r - 1][c] = headValue + 1;
				}
			}

			if (c > 0) {
				if (matrix[r][c - 1] && tracker[r][c - 1] > headValue + 1) {
					tail++;
					queueRow[tail] = r;
					queueColumn[tail] = c - 1;
					tracker[r][c - 1] = headValue + 1;
				}
			}

			if (r < row - 1) {
				if (matrix[r + 1][c] && tracker[r + 1][c] > headValue + 1) {
					tail++;
					queueRow[tail] = r + 1;
					queueColumn[tail] = c;
					tracker[r + 1][c] = headValue + 1;
					if (r + 1 == row - 1 && c == column - 1) {
						break;
					}
				}

			}

			if (c < column - 1) {
				if (matrix[r][c + 1] && tracker[r][c + 1] > headValue + 1) {
					tail++;
					queueRow[tail] = r;
					queueColumn[tail] = c + 1;
					tracker[r][c + 1] = headValue + 1;
				}
				if (r == row - 1 && c + 1 == column - 1) {
					break;
				}
			}

			head++;
		}

		return tracker;
	}

	// Input: boolean matrix(m, n)
	// => Find max Square contains only false
	public static Rectangle findMaxSquare(boolean[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		int[] square = new int[column]; // MaxSquare from each position to LeftTop
		int[] vertical = new int[column]; // MaxHeigh from each position

		Rectangle result = new Rectangle(-1, -1, 0, 0);
		for (int i = 0; i < row; i++) {
			int segment = 0;
			int pre = 0;
			for (int j = 0; j < column; j++) {
				if (!matrix[i][j]) {
					segment++;
					vertical[j]++;
				}
				else {
					segment = 0;
					vertical[j] = 0;
				}
				int current = square[j];
				square[j] = Math.min(pre + 1, Math.min(segment, vertical[j]));
				pre = current;

				if (square[j] > result.width) {
					result.width = result.height = square[j];
					result.x = i - result.width + 1;
					result.y = j - result.height + 1;
				}
			}
		}
		return result;
	}

	static class Rectangle {
		int x;
		int y;
		int width;
		int height;

		public Rectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public String toString() {
			return "(" + x + "," + y + ":" + width + "," + height + ")";
		}
	}

	// Input: boolean matrix(m, n)
	// => Find max Rectangle contains only false
	public static Rectangle findMaxRectangle(boolean[][] matrix) {
		return null;
	}

	public static void main(String[] args) {
		boolean[][][] matrixTestcases = new boolean[][][] {
				{
				{ true, true, false, true, true, true, true, true, true },
				{ true, true, false, true, true, false, false, false, true },
				{ true, true, false, true, true, false, true, true, true },
				{ true, true, false, true, true, false, true, false, false },
				{ true, true, false, true, true, false, true, true, true },
				{ true, true, true, true, true, false, true, true, true }
		},
				{
				{ true, false, false, true, true, true, true, true, true },
				{ true, false, false, false, false, false, false, false, true },
				{ true, false, false, false, false, false, false, false, true },
				{ true, false, false, true, false, false, false, false, true },
				{ true, false, true, true, false, false, false, false, true },
				{ true, true, true, true, true, true, false, false, true }
		},
		};

		for (int i = 0; i < matrixTestcases.length; i++) {
			boolean[][] matrix = matrixTestcases[i];
			int[][] path = findMinPath(matrix);
			printMatrix(path);
			Rectangle maxRec = findMaxSquare(matrix);
			System.out.println(maxRec.toString());
		}
	}

	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			for (int j = 0; j < row.length; j++) {
				System.out.print((row[j] < 100 ? row[j] : "    ") + "\t");
			}
			System.out.println();
		}
	}
}
