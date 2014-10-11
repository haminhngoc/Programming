import java.util.*;

class VBGRASS {

	public static void main(String[] args) {
		VBGRASSSolver solver = new VBGRASSSolver();
		solver.solve();
	}

}

class VBGRASSSolver {	
	private static Scanner in = new Scanner(System.in);
	private static int count = 0;
	int row = 0;
	int col = 0;
	int [][] label;
	
	public void solve() {
		row = in.nextInt();
		col = Integer.parseInt(in.nextLine().trim());
		label = new int[row][col];
		char [][] field = new char[row][col];
		for (int i = 0; i < row; i++) {
			char[] chars = in.nextLine().toCharArray();
			field[i] = chars;
		}
		
		
		for (int i = 0; i < row; i++) {			
			for (int j = 0; j < col; j++) {
				if (field[i][j] == '#' && label[i][j] == 0) {					
					dfs(field, i, j);
					count++;				
				}				
			}		
		}	
		System.out.println(count);
	}
	
	public void dfs(char[][] field, int i, int j) {		
		if (field[i][j] == '#' && label[i][j] == 0) {
			label[i][j] = 1;			
			if (j < col - 1) {
				dfs(field, i, j + 1);		
			}
			if (j > 1) {
				dfs(field, i, j - 1);		
			}
			if (i > 1) {
				dfs(field, i - 1, j);
			}
			if (i < row - 1) {
				dfs(field, i + 1, j);
			}
		}
	}
}
