import java.util.*;


public class CountGoodSubstrings {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		String input;
		input = readers.nextLine();
		char [] array= input.toCharArray();
		int even=0,odd=array.length,total=array.length;
		int index=0,i=1;
		if(total%2==0) even++;
		else odd++;
		System.out.print(array.length+"\n");
		System.out.print("\n"+even+" "+odd+" "+total);
		while(i<array.length)
		{
			if(array[i-1]!=array[i])
			{
				if(i-index-1>0)
				{
					if((i-index)%2==0) even++;
					else odd++;
					total=total - (i-index)+1;
				}
				index=i;
			}
			i++;
			System.out.print("\n"+even+" "+odd+" "+total);
		}
		System.out.print("\n"+index+" "+i);
		if(i-index>0)
		{
			if((i-index)%2==0) even++;
			else odd++;
			total=total - (i-index)+1;
		}
		System.out.print("\n"+even+" "+odd+" "+total);
		if(total%2==0) even++;
		else odd++;
		System.out.print(even+" "+odd);

	}

}
