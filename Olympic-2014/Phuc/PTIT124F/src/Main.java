import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int countR = 0;
	static int count = 1;
	static List<Integer>[] list;
	static int m;
	static boolean isUsed[];
	static int result[];
	static StringBuilder str;

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		m = n << 1;
		int primes[] = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		list = new List[2 * n + 1];
		for (int i = 1; i <= m; ++i) {
			list[i] = new ArrayList<Integer>();
			int primeL = primes.length;
			for (int j = 0; j < primeL; ++j) {
				if (primes[j] <= i || primes[j] - i == i) {
					continue;
				}
				if (primes[j] - i > m) {
					break;
				}
				list[i].add(primes[j] - i);
			}
		}
		isUsed = new boolean[m + 1];
		isUsed[1] = true;
		result = new int[m];
		result[0] = 1;
		str = new StringBuilder();
		dfs(1);
		System.out.println(System.currentTimeMillis()-st);
		//System.out.println(countR);
		//System.out.print(str);
	}

	private static void dfs(int current) {
		int l = list[current].size();
		for (int i = 0; i < l; ++i) {
			if (!isUsed[list[current].get(i)]) {

				result[count] = list[current].get(i);
				count++;
				isUsed[list[current].get(i)] = true;
				if (count == m) {
					int temp = result[0] + result[m - 1];
					if (temp == 3 || temp == 5 || temp == 7 || temp == 11
							|| temp == 13 || temp == 17 || temp == 19
							|| temp == 23 || temp == 29 || temp == 31
							|| temp == 37) {
						countR++;
						if (countR <= 10000) {
							str.append(1);
							for (int j = 1; j < m; ++j) {
								str.append(" ");
								str.append(result[j]);
							}
							str.append("\n");
						}
					}

				} else {
					dfs(list[current].get(i));
				}
				isUsed[list[current].get(i)] = false;
				count--;
			}
		}
	}
}
