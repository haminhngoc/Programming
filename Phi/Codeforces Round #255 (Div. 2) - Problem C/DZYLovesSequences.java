import java.util.*;

public class DZYLovesSequences {

	public static void main(String[] args) {
		
		int[] arr = new int[100000];
		int n;
		int left = 0, mid = 0;
		int longest = 2;
		
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		if (arr[0] > arr[1])
		{
			mid = 1;
		}
		
		for (int i = 2; i < n; i++)
		{
			arr[i] = sc.nextInt();
			if (arr[i] < arr[i-1] && arr[i] >= arr[i-2]) // level 1
			{
				if (mid != left)
				{
					longest = longest > i - left + 1 ? longest : i -left + 1;
					left = mid;
					mid = i;
				}
				else
				{
					mid = i;
				}
			}
			if (arr[i] < arr[i-2]) // level 2
			{
				longest = longest > i - left + 1 ? longest : i -left + 1;
				left = i -1;
				mid = i - 1;
			}
		}
		System.out.println(longest);
		
	}
}
