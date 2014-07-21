import java.util.Scanner;


public class Codeforce_447_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min=Integer.MIN_VALUE;
		Scanner scan = new Scanner(System.in);
		int nArr=scan.nextInt();
		int arr[]=new int [nArr+1];
		arr[nArr]=min;
		for(int i=0; i<nArr; i++)
		{
			arr[i]=scan.nextInt();
		}
		int newStart=0, max=0, start=0;
		while (newStart<nArr)
		{
			start=newStart;
			int skip=1;
			int i=start;
			while ((skip>-1)&&(i<nArr))
			{
				if (arr[i+1]<arr[i])
				{
					if(skip==1)
					{
						skip=0;
						newStart=i+1;
						if((newStart<nArr)&&(arr[newStart+1]<arr[newStart-1]))
							{
							if(max<i-start+1)max=i-start+1;
							System.out.println(start+" to "+i+" "+(i-start+1));
							skip=-1;
							}
						i++;	
					}
					else
					{
						if(max<i-start+1)max=i-start+1;
						System.out.println(start+" to "+i+" "+(i-start+1));
						skip=-1;
					}
				}
				else
				{
					i++;
				}
			}
		}
		System.out.println(max);
		scan.close();
	}

}
