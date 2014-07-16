import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class DZYLovesStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wLetter = new int[26];
		Scanner sc = new Scanner(System.in);
		String str;
		int result = 0, max = 0;
		int k,i,t;
		str = sc.nextLine();
		k = sc.nextInt();
		for (i = 0; i < 26; i++) {
			t = sc.nextInt();
			wLetter[i] = t;
			if (wLetter[i] > max)
			{
				max = wLetter[i];
			}
		}
		for (i = 1; i <= str.length() ; i++)
		{
			result += (wLetter[(int)str.charAt(i-1)-97])*i;
		}
		for(int j = 0; j < k; j++)
		{
			result += max*i;
			i++;
		}
		sc.close();
		System.out.println(result);
	}
}

