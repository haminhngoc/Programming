import java.util.Scanner;

public class LittlePonyAndSortByShift {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		n = readers.nextInt();
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = readers.nextInt();
		}
		
		int i=0,count=0;
		int flag1=-1,flag2=-1;
		while(i<n-1)
		{
			if(flag1==-1 && array[i] > array[i+1]){
				flag1=i;
				count++;
			}
			else if(flag1!=-1){
				//if(i-1==flag1) count++;
				if( array[i]<=array[i+1])
					count++;
				else {
					System.out.print(-1);
					return;
				}
			}
			i++;
		}
		if(array[0]<array[n-1] && flag1!=-1) System.out.print(-1);
		else System.out.print(count);	
	}

}
