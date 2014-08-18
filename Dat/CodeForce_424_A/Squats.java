import java.util.Scanner;


public class Squats {
	private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n;
		String characters ;
		n= readers.nextInt();
		characters= readers.next();
		char []array=characters.toCharArray();
		int count=0;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]=='x') count++; 
		}
		if(count==n/2) {
			System.out.print(0+"\n"+characters);
		}
		else{
			int temp=Math.abs(count-n/2),i=0;
			System.out.print(temp+"\n");
			while(temp>0){
				if(count>n/2 && array[i]=='x'){
					array[i]='X';	
					temp--;
				}
				else if(count<n/2 && array[i]=='X'){
					array[i]='x';
					temp--;
				}
				i++;				
			}
			for(i=0;i<array.length;i++)
			{
				System.out.print(array[i]);
			}
		}
		
	}

}
