import java.util.*;

public class SuffixStructures {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		String s = reader.nextLine().trim(); // 100
		String t = reader.nextLine().trim(); // 100

		if (SuffixAutomaton(s, t)) {
			System.out.println("automaton");
		} else {

			if (SuffixArray(s, t)) {
				if (s.length() == t.length())
					System.out.println("array");
				else
					System.out.println("both");
			} else
				System.out.println("need tree");
		}
	}

	private static Boolean SuffixAutomaton(String s, String t) {
		int Slength = s.length();
		int Tlength = t.length();
		int index = 0;
		int nDone = 0;
		while (index < Slength) {
			if (s.charAt(index) == t.charAt(nDone))
			{
				nDone++;
				if (nDone == Tlength)
					break;
			}
			index++;
		}
		if (nDone == Tlength)
			return true;
		return false;
	}

	private static Boolean SuffixArray(String s, String t) {
		int[] Scounter = new int[26];
		int[] Tcounter = new int[26];
		int[] label = new int[26];
		int Slength = s.length();
		int Tlength = t.length();
		for (int i = 0; i < Slength; i++) {
			int charcode = -97 + (int) s.charAt(i);
			Scounter[charcode]++;
		}
		for (int i = 0; i < Tlength; i++) {
			int charcode = -97 + (int) t.charAt(i);
			Tcounter[charcode]++;
		}
		for (int i = 0; i < 26; i++) {
			if (Scounter[i] >= Tcounter[i] && Scounter[i] * Tcounter[i] != 0)
				label[i] = 1;
		}
		if (CountLetters(label) == CountLetters(Tcounter))
			return true;
		return false;
	}

	private static int CountLetters(int[] alphabet) {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > 0)
				count++;
		}
		return count;
	}
}
