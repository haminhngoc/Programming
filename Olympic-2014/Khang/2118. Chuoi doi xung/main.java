import java.util.*;

class main {

	private static Scanner reader = new Scanner(System.in);

	private enum Type {
		TEST, EXECUTE
	}

	public static void main(String[] args) {
		try {
			while (reader.hasNextLine()) {
				Solve(reader.nextLine(), Type.EXECUTE);	
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} finally {	
		}

	}

	private static void Solve(String input, Type t) {
		char[] letters = input.toCharArray();
		int start = 0;
		int length = letters.length - 1;
		int end = length;
		int curr = end;
		StringBuilder firstHalf = new StringBuilder();
		StringBuilder lastHalf = new StringBuilder();
		Boolean flag = false;
		while (true) {
			if (start == end) {	
				if (length == 0) {
					firstHalf.append(letters[0]);
				}
				break;
			}
			
			if (end - start == 1 && letters[start] != letters[end]) {
				firstHalf.append(letters[start]);
				break;
			}
	
			curr = end;
			flag = false;
			while (curr > start) {
				if (letters[start] == letters[curr]) {
					firstHalf.append(letters[start]);
					lastHalf.insert(0, letters[curr]);					
					end = curr;
					flag = true;
					start++;
					if (end - start > 1)
						end--;			
					break;					
				}
				curr--;			
			}
			if (!flag && start < end) { start++; }		
		}

		if (t == Type.EXECUTE) {
			System.out.println(firstHalf.toString() + lastHalf.toString());
		} else {
			System.out.print(firstHalf.toString() + lastHalf.toString());
			Test(firstHalf.toString() + lastHalf.toString(), length + 1);
		}
	}

	private static void Test(String input, int Inputlength) {
		char [] letters = input.toCharArray();
		int length = letters.length;
		int start = 0;
		int end = length - 1;
		boolean flag = true;
		if (Inputlength < length) { 
			System.out.println("   WRONG"); 
			return;
		}
		
		while (true) {
			if (letters[start] != letters[end]) {
				flag = false;
				break;			
			}	
			
			if (start == length / 2) {
				break;
			}
			start++;
			end--;
		}
		if (flag) { System.out.println("   ACCEPTED"); }
		else { System.out.println("   WRONG"); }
		
	}
	
}
