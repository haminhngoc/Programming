import java.util.*;

public class PoliceRecruits {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		n = readers.nextInt();
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = readers.nextInt();
		}
		int result = 0, totalPolice = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] > 0)
				totalPolice += array[i];
			else {
				if (totalPolice >= -array[i])
					totalPolice += array[i];
				else {
					result += (-array[i] - totalPolice);
					totalPolice = 0;
				}
			}
		}
		System.out.print(result);

	}

}
