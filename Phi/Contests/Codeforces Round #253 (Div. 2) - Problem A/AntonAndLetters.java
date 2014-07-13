import java.util.Arrays;
import java.util.Scanner;

public class AntonAndLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String in = new String();
		in = sc.nextLine(); 
		in = in.replaceAll("[{}]", "");
		sc.close();
		int result = solve(in);
		System.out.println(result);
	}
	static int solve(String n) {
		int length = n.length() == 0 ? 0 : 1;
		String[] parts = n.split(", ");
		Arrays.sort(parts);
		for(int i = 1; i < parts.length; i++)
		{
			String a = parts[i-1];
			String b = parts[i];
			if (!a.equals(b))
			{
				length++;
			}
		}
		return length;
	}
}

