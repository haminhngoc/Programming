import java.util.Scanner;

public class Codeforces_421_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt();
		int arrA[] = new int[a];
		boolean arr[] = new boolean[n + 1];
		int arrB[] = new int[b];
		for (int i = 0; i < a; i++) {
			arrA[i] = scan.nextInt();
			arr[arrA[i]] = true;
		}
		for (int i = 0; i < b; i++)
			arrB[i] = scan.nextInt();
		for (int i = 1; i <= n; i++){
			if (arr[i] == false)
				System.out.print(2 + " ");
			else System.out.print(1 + " ");
		}
		scan.close();
	}

}
