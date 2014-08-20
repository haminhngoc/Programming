import java.util.Scanner;


public class A5 {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n;
		n=readers.nextInt();
		int[] array= new int [n];
		for(int i=0;i<n;i++)
		{
			array[i]=readers.nextInt();
		}
		int max=0,start=0,end=n-1;
		int i=0,j=n-1;
		for(i=0;i<n-2;i++)
		{
			for(j=n-1;j>i;j--){
				if(array[j]-array[i]>max){
					max=array[j]-array[i];
					start=i;
					end=j;
				}
			}
		}
		System.out.print(start+"  "+end);

	}

}
