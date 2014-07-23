import java.util.Scanner;


public class DZYLovesStrings {
	private static Scanner readers= new Scanner(System.in);
	public static void main(String[] args) {
		String input= "";
		int k=0,max=0,index=0,total=0;
		int [] value= new int [26];
		input= readers.nextLine();
		k= readers.nextInt();
		max=value[0]=readers.nextInt();
		for(int i=1;i<26;i++)
		{
			value[i]= readers.nextInt();
			if(value[i]>max){
				index=i;
				max=value[i];
			}
		}
		for(int i=0;i<input.length();i++)
		{
			
			total+=(value[(int)input.charAt(i)-(97)])*(i+1);
			
		}
		for(int i=0;i<k;i++)
		{
			input+=String.valueOf((char)(index + 97));
			total+=value[index]*(input.length());
		}
		System.out.print(total);

	}

}
