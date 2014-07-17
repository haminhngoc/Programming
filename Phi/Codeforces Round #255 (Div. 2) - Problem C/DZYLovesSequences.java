import java.util.*;

public class DZYLovesSequences {

	public static void main(String[] args) {
		
		int[] arr = new int[100000];
		int[] longest = new int[100000];
		int n, max = 2;
		int lastEnd = 0;
		int hasMistakeAt = 0;
		int longestSub = 2;
		
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		if (arr[0] > arr[1])
		{
			hasMistakeAt = 1;
		}
		longest[0] = 1;
		longest[1] = 2;
		
		for (int i = 2; i < n; i++)
		{
			arr[i] = sc.nextInt();
			if (arr[i] >= arr[i-1] &&  hasMistakeAt != 0)
			{
				longestSub =  longestSub > i- lastEnd + 1 ? longestSub : i- lastEnd + 1;
				lastEnd = i;
			}
			else if (noMistake)
			{
				longest[i] = longest[i-1] + 1;
				noMistake = false;
			}
			else
			{
				longest[i] = longest[i-1];			
			}
			if (longest[i] > max)
			{
				max = longest[i];
			}
		}
		System.out.println(max);
		
	}
}
