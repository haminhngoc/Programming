import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class VMUNCH {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		char[][] arrG = new char[row][col];// Garden array
		for (int iR = 0; iR < row; ++iR) {
			String s = in.next();
			arrG[iR] = s.toCharArray();
		}

		int rStart = 0;
		int cStart = 0;
		int rEnd = 0;
		int cEnd = 0;
		int[][] arrS = new int[row][col];// Step array
		for (int iR = 0; iR < row; ++iR)
			for (int iC = 0; iC < col; ++iC) {
				if (arrG[iR][iC] == '*')
					arrS[iR][iC] = -1;
				if (arrG[iR][iC] == '.')
					arrS[iR][iC] = Integer.MAX_VALUE;
				if (arrG[iR][iC] == 'C') {
					arrS[iR][iC] = Integer.MAX_VALUE;
					rEnd = iR;
					cEnd = iC;
				}
				if (arrG[iR][iC] == 'B') {
					arrS[iR][iC] = 0;
					rStart = iR;
					cStart = iC;
				}
			}
		markStep(rStart, cStart, arrS, row, col);

		/*for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j)
				System.out.print(arrS[i][j]);
			System.out.println();
		}*/
		System.out.print(arrS[rEnd][cEnd]);
	}

	private static void markStep(int r, int c, int[][] arrS, int row, int col) {
		int val = arrS[r][c] + 1;
		if (r > 0 && arrS[r - 1][c] > val) {
			arrS[r - 1][c] = val;
			markStep(r - 1, c, arrS, row, col);
		}
		if (r < row - 1 && arrS[r + 1][c] > val) {
			arrS[r + 1][c] = val;
			markStep(r + 1, c, arrS, row, col);
		}
		if (c > 0 && arrS[r][c - 1] > val) {
			arrS[r][c - 1] = val;
			markStep(r, c - 1, arrS, row, col);
		}
		if (c < col - 1 && arrS[r][c + 1] > val) {
			arrS[r][c + 1] = val;
			markStep(r, c + 1, arrS, row, col);
		}
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}