import java.util.Scanner;

public class Codeforces_451_B {
static int left=1;
static int right=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n + 2];
		a[n+1] = Integer.MAX_VALUE;
		a[0]=Integer.MIN_VALUE;
		for (int i = 1; i < n+1; i++)
			a[i] = scan.nextInt();
		if (CheckArr(a, n) == true)
		{
			System.out.println("yes");
			System.out.println(left+ " "+right);
		}
		else
			System.out.println("no");
		scan.close();
	}

	private static boolean CheckArr(int[] a, int n) {
		// TODO Auto-generated method stub
		int top=1, i=1, nReverse=1;
		while (top<n)
		{
			if (a[top+1]>a[top])top++;
			else
			{
				if(nReverse==0)return false;
				left=top;
				if(a[top+i]<a[top])
				{
					if((a[top+i]<a[top+i-1])&&(a[top+i]>a[top-1]))i++;
					else return false;
				}
				else
				{
					nReverse=0;
					top=top+i;
				}
			}
		}
		right=left+i-1;
		return true;
	}

}
