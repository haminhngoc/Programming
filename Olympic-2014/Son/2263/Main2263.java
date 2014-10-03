import java.util.Scanner;


public class Main2263 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		int n;//n=60000;
		n=reader.nextInt();
		int [] a= new int[n];
		for(int i=0;i<n;i++)
			a[i]=reader.nextInt();
		int count=0;
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				if(a[i]>a[j])
					count++;
		System.out.println(count);
			

	}

}
