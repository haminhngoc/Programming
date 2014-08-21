import java.util.Scanner;

public class KTree {
	private static Scanner readers = new Scanner(System.in);

	private static int solve(int n, int k, int d,int currentRow, int total, boolean isLeast) 
	{
		int result = 0;
		for (int i = 1; i < k; i++) {
			if (total+i > n)
				return result;
			else if (total+i == n) {
				if (isLeast == true || i>=d)
					result += 1;
			} 
			else {
				if(currentRow<k-1){
					if(i>=d)
						result += solve(n, k, d,currentRow+1, total+i, true);
					else result += solve(n, k, d,currentRow+1, total+i, false);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int n, k, d;
		n = readers.nextInt();
		k = readers.nextInt();
		d = readers.nextInt();
		int result = solve(n, k, d,1, 0, false);
		System.out.print(result % 1000000007 );
	}

}
