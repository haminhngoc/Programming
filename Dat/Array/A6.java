import java.util.Scanner;


public class A6 {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n;
		n=readers.nextInt();
		int[] array = new int [n];
		int [] temp = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=readers.nextInt();
			if(i==0) temp[0]=array[0];
			else temp[i]=temp[i-1]+array[i];
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
