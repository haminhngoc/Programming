import java.util.*;

public class HelpfulMaths {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		String sumString = reader.nextLine();
		String[] numberStrings = sumString.trim().split("[+]");
		int[] numbers = new int[numberStrings.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numberStrings[i].toString());
		}
		Arrays.sort(numbers);
		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			if (i < numbers.length - 1)
				result += numbers[i] + "+";
			else
				result += numbers[i];
		}		
		System.out.println(result);
	}

}
