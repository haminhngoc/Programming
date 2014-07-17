import java.util.Scanner;


public class Codeforce_447_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str=scan.next();
		int k=scan.nextInt();
		int wChar[]=new int [26];
		int nStr=str.length();
		int max=0;
		for (int i=0; i<26; i++)
		{
			wChar[i]=scan.nextInt();
			if(wChar[i]>max)max=wChar[i];
		}
		int result=0;
		for (int i=0; i<nStr; i++)
		{
			result+=(i+1)*wChar[((int)str.charAt(i)-97)];
			//System.out.print("("+wChar[((int)str.charAt(i)-97)]+"x"+(i+1)+")+");
		}
		for (int i=1; i<=k; i++)
		{
			result+=max*(i+nStr);
			//System.out.print("("+max+"x"+(i+nStr)+")+");
		}
		System.out.println(result);
		scan.close();
	}

}
