import java.util.Scanner;

public class Codeforces_433_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		int a[] = new int[m + 1];
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < n + 1; j++)
				arr[i][j] = 0;
		int same = 0;
		a[0] = scan.nextInt();
		for (int i = 1; i < m; i++) {
			int x = scan.nextInt();
			if (x != a[i - 1])
				a[i - same] = x;
			else {
				same++;
			}
		}
		m -= same;
		if (a[m - 1] == a[m - 2])
			m--;
		a[m] = a[m - 2];

		int pos[] = new int[n+1], nPos = 1;
		int link[][] = new int[m+1][m+1], nLink[] = new int[m+1];
		int tPos[] = new int[n + 1];
		for (int i = 1; i < n; i++)
			tPos[i] = -1;
		pos[0] = a[0];
		tPos[a[0]] = 0;
		link[0][0] = a[1];
		nLink[0] = 1;
		arr[a[0]][a[1]]++;
		for (int i = 1; i < m; i++) {
			if ((a[i] > a[i - 1] && a[i] > a[i + 1])||(a[i] < a[i - 1] && a[i] < a[i + 1]))
				if (tPos[a[i]] == -1) {
					pos[nPos] = a[i];
					tPos[a[i]] = i;
					link[nPos][0] = a[i - 1];
					link[nPos][1] = a[i + 1];
					nLink[nPos] = 2;
					arr[a[nPos]][a[i - 1]]++;
					arr[a[nPos]][a[i + 1]]++;
					nPos++;
				} else {
					int x = tPos[a[i]], y = nLink[x];
					if (arr[a[i]][a[i - 1]] == 0) {
						link[x][y] = a[i - 1];
						nLink[x]++;
					}
					if (arr[a[i]][a[i + 1]] == 0) {
						link[x][y + 1] = a[i + 1];
						nLink[x]++;
					}
					arr[a[i]][a[i - 1]]++;
					arr[a[i]][a[i + 1]]++;
				}
		}
		arr[a[m - 1]][a[m]]--;
		nLink[tPos[a[m - 1]]]--;

		int maxReduce = 0;
		for (int i = 0; i < nPos; i++) {
			int x = Check(i, pos[i], nLink[i], link, arr);
			if (maxReduce < x)
				maxReduce = x;
		}
//test
		for (int i = 0; i < m; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
		for (int i = 0; i < nPos; i++) {
			System.out.print(i + "|" + pos[i] + "|" + nLink[i] + "| ");
			for (int j = 0; j < nLink[i]; j++)
				System.out.print(link[i][j] + " ");
			System.out.println("");
		}

		for (int i = 0; i < n + 1; i++)
			System.out.print(i + "|");
		System.out.println("");
		for (int i = 1; i < n + 1; i++) {
			System.out.print(i + "|");
			for (int j = 1; j < n + 1; j++)
				System.out.print(arr[i][j] + "|");
			System.out.println("");
		}

		int turns = 0;
		for (int i = 1; i < m; i++)
			turns += abs(a[i] - a[i - 1]);
		System.out.println(turns - maxReduce);
		scan.close();
	}

	private static int Check(int i, int x, int n, int[][] link, int[][] arr) {
		// TODO Auto-generated method stub
		int base = 0;
		for (int j = 0; i < n; i++) {
			int y = link[i][j];
			base += abs(arr[x][y] * (y - x));
		}
		int max = 0;
		for (int k = 0; k < n; k++) {
			x = link[i][k];
			int calX = 0;
			for (int j = 0; i < n; i++) {
				int y = link[i][j];
				calX += abs(arr[x][y] * (y - x));
			}
			if (max < base - calX)
				max = base - calX;
		}

		return max;
	}

	private static int abs(int x) {
		// TODO Auto-generated method stub
		if (x < 0)
			return -x;
		return x;
	}

}
