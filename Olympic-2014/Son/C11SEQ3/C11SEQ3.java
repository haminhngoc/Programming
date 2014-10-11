import java.util.Arrays;
import java.util.Scanner;


public class C11SEQ3 {

	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		String[] s= new String [30];
		s[0]="1";
		for(int i=1;i<30;i++)
		{
			int tmp=Integer.parseInt(s[i-1]);
			tmp*=2;
			String tmp2=Integer.toString(tmp);
			s[i]=SolveFi(tmp2);
		}
		int n;//n=10^9;
		n=reader.nextInt();
		if(n<25)
			System.out.println(s[n-1]);
		else
		{
			int index=(n-25)%6;
			System.out.println(s[index+25-1]);
		}

	}
	public static String SolveFi(String s)
	{
		String result="";
		char[] a=s.toCharArray();
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			if(a[i]!='0')
			result+=a[i];
		return result;
	}

}
