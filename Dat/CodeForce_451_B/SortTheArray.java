import java.util.*;

public class SortTheArray {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		n = readers.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readers.nextInt();
		}
		int startIndex = 0, endIndex = n - 1;
		
		while (startIndex<n-1 && array[startIndex] < array[startIndex + 1] )
			startIndex++;		
		
		if (startIndex == n-1)
			System.out.print("yes\n" + 1 + " " + 1);
		else {
			while (endIndex>1 && array[endIndex - 1] < array[endIndex] )
				endIndex--;
			boolean isSort = false;
			int index = startIndex;
			while (array[index] > array[index + 1] && index < endIndex-1)
				index++;
			if (index < endIndex-1)
				System.out.print("no");
			else {
				if(startIndex==0 && endIndex==n-1)
					System.out.print("yes\n" + (startIndex+1) + " "
							+ (endIndex+1));
				else if(startIndex==0 && array[startIndex]<array[endIndex+1])
					System.out.print("yes\n" + (startIndex+1) + " "
							+ (endIndex+1));
				else if(endIndex==n-1 && array[startIndex-1]<array[endIndex])
					System.out.print("yes\n" + (startIndex+1) + " "
							+ (endIndex+1));
				else if (startIndex>0 && endIndex<n-1 && array[startIndex] < array[endIndex + 1]
						&& array[startIndex - 1] < array[endIndex])
					System.out.print("yes\n" + (startIndex+1) + " "
							+ (endIndex+1));
				else System.out.print("no");
				
			}
		}

	}

}
