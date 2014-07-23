import java.util.Scanner;


public class PashaAndHamsters {
	private static Scanner readers= new Scanner(System.in);
	private static int []result;
	private static void fill(int[] array,int type)
	{
		for(int i=0;i<array.length;i++)
		{
			if(result[array[i]-1]==-1) result[array[i]-1] =type;
		}
	}
	public static void main(String[] args) {
		int n,a,b;
		n= readers.nextInt();
		a=readers.nextInt();
		b=readers.nextInt();
		result= new int[n];
		int [] Arthur =new int[a];
		int [] Alexander = new int [b];
		for(int i=0;i<a;i++)
			Arthur[i]=readers.nextInt();
		for(int i=0;i<b;i++)
			Alexander[i]=readers.nextInt();
		
		for(int i=0;i<n;i++)
			result[i]=-1;
		if(a>b){
			fill(Arthur,1);
			fill(Alexander,2);			
		}
		else{
			fill(Alexander,2);
			fill(Arthur,1);
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(result[i]+" ");
		}
	}

}
