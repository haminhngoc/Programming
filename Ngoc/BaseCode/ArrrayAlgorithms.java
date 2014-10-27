import java.util.*;

//import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode.ArrayUnit;

public class ArrrayAlgorithms {

	/*****************************************************************
	 ************* LINEAR PARTITION ***********************************
	 *****************************************************************/

	/*
	 * Edited by 
	 */
	public static void lomutoPartition(long[] array, int pivot) {
	}

	/*
	 * Edited by 
	 */
	public static void hoarePartition(long[] array, int pivot) {
	}

	/*
	 * Edited by 
	 */
	public static long kthElement(long[] array, int k) {
		return 0;
	}

	/*****************************************************************
	 ************* SAMPLE CUSTOM SORT AND SEARCH **********************
	 *****************************************************************/

	/*
	 * Sort by multiple condition Edited by 
	 */

	/*
	 * LowerBound Edited by 
	 */

	/*
	 * UpperBound Edited by 
	 */

	/*****************************************************************
	 ***************** SAMPLE CUSTOM HEAP *****************************
	 *****************************************************************/

	/*
	 * Heap ~ PriorityQueue Edited by 
	 */

	/*
	 * Fibonacci Heap Edited by 
	 */

	/*****************************************************************
	 ************************** 2D ARRAY *****************************
	 *****************************************************************/

	/*
	 * Search in increase 2d array, Edited by 
	 */

	/*
	 * Partition in increase 2d array, Edited by Duy & 
	 */

	/*****************************************************************
	 ************************** SEARCH *****************************
	 *****************************************************************/

	/*
	 * + Longest increase subArray + Maximize (Max(sub) - Min(sub)) + Maximize (LocalMaximum - LocalMinimum) + Maximize (LocalMaximum - LocalMinimum) with condition LocalMinimum has appear before
	 * LocalMaximum + SubArray has maximum total
	 */

	/*****************************************************************
	 ************************** TWO ARRAY *****************************
	 *****************************************************************/

	// Longest Common Sub-Sequence
	static char[] LCS(char[] s1, char[] s2) {
		int[][] map = buildLCSMap(s1, s2);

		char[] result = readLCSResult(s1, s2, map);
		return result;
	}

	static String[] LCSAll(char[] s1, char[] s2) {
		int[][] map = buildLCSMap(s1, s2);
		String[][][] cache = new String[s1.length + 1][s2.length + 1][];

		String[] result = readLCSAllResult(s1, s2, map, s1.length, s2.length, cache);
		return result;

	}

	static int[][] buildLCSMap(char[] s1, char[] s2) {
		int len1 = s1.length;
		int len2 = s2.length;

		int[][] map = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			char c1 = s1[i - 1];
			for (int j = 1; j <= len2; j++) {
				if (c1 == s2[j - 1]) {
					map[i][j] = map[i - 1][j - 1] + 1;
				}
				else {
					map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
				}
			}
		}
		return map;
	}

	static char[] readLCSResult(char[] s1, char[] s2, int[][] map) {
		int len1 = s1.length;
		int len2 = s2.length;
		int maxLen = map[len1][len2];

		char[] result = new char[maxLen];

		int current = maxLen - 1;
		int i = len1;
		int j = len2;

		while (i > 0 && j > 0) {
			if (s1[i - 1] == s2[j - 1]) {
				result[current--] = s1[i - 1];
				i--;
				j--;
			}
			else if (map[i][j] == map[i - 1][j]) {
				i--;
			}
			else { // ma[i][j] == map[i][j-1]
				j--;
			}
		}
		return result;
	}

	static String[] readLCSAllResult(char[] s1, char[] s2, int[][] map, int x, int y, String[][][] cache) {

		if (cache[x][y] != null) {
			return cache[x][y];
		}

		if (x == 0 || y == 0) {
			return null;
		}

		String[] result = null;
		if (s1[x - 1] == s2[y - 1]) {
			String[] preCache = readLCSAllResult(s1, s2, map, x - 1, y - 1, cache);

			if (preCache == null) {
				preCache = new String[] { "" };
			}

			result = cache[x][y] = new String[preCache.length];
			for (int i = 0; i < preCache.length; i++) {
				result[i] = preCache[i] + s1[x - 1];
			}

			return result;
		}

		String[] left = null, right = null;

		if (map[x - 1][y] >= map[x][y - 1]) {
			left = readLCSAllResult(s1, s2, map, x - 1, y, cache);
		}

		if (map[x - 1][y] <= map[x][y - 1]) {
			right = readLCSAllResult(s1, s2, map, x, y - 1, cache);
		}

		if (left != null && right != null && left != right) {
			result = unionTwoArray(left, right);
		}
		else {
			result = left != null ? left : right;
		}

		cache[x][y] = result;
		return result;
	}

	static String[] unionTwoArray(String[] s1, String[] s2) {
		int count = 0;
		String[] temp = new String[s2.length];

		for (int j = 0; j < s2.length; j++) {
			int i = 0;
			for (i = 0; i < s1.length; i++) {
				// Distinct location
				// if (s2[j] == s1[i]) {
				// break;
				// }
				
				// Disinct result
				if (s2[j].compareTo(s1[i]) == 0) {
					break;
				}
			}
			if (i == s1.length) {
				temp[count++] = s2[j];
			}
		}
		String[] result = new String[s1.length + count];
		for (int i = 0; i < count; i++) {
			result[i] = temp[i];
		}
		for (int i = 0; i < s1.length; i++) {
			result[count + i] = s1[i];
		}
		return result;
	}

	/*****************************************************************
	 ************************** TEST *****************************
	 *****************************************************************/

	public static void main(String[] args) {

		String[][] testcases = new String[][] {
				{ "fsdffdsfd", "sfdddfsd", "5" },
				{ "", "", "0" },
				{ "", "fsdfasdfs", "0" },
				{ "fdfasdf", "d", "1" },
				{ "XMJYAUZ", "MZJAWXU", "4" },
				{ "cdadfvfdjngmtuybdcmkhjcacifkcijjjphcjkhjxiwdbecibjhpppudhocgduylgrskubdhqoipaxuflolseyiejlulrhnuypnf",
						"fddiwmgeqvankhognumgchqoawnviaqvgurkkwuqxaqfhyhxcwhjqknvyqknfokxhspkkyrxvqyvffnyvbijerb", "26" }
		};

		Random rand = new Random();

		for (int i = 0; i < testcases.length && true; i++) {
			String[] testcase = testcases[i];
			if (testcase.length >= 3) {
				char[] s1 = testcase[0].toCharArray();
				char[] s2 = testcase[1].toCharArray();
				char[] result = LCS(s1, s2);
				int resultLen = result.length;
				System.out.println(testcase[0] + "   vs.   " + testcase[1] + " => " + (resultLen == Integer.parseInt(testcase[2])) + ": " + new String(result));
			}
		}
		for (int i = 0; i < testcases.length; i++) {
			String[] testcase = testcases[i];
			if (testcase.length >= 3) {
				System.out.println("============================================================");
				char[] s1 = testcase[0].toCharArray();
				char[] s2 = testcase[1].toCharArray();
				String[] result = LCSAll(s1, s2);
				if (result != null) {
					int resultLen = result.length;
					System.out.println(resultLen);
					for (int j = 0; j < resultLen; j++) {
						System.out.println(result[j]);
					}
				}
				System.out.println();
			}
		}

		int charCount = 'z' - 'a';
		for (int i = 0; i < 10 && false; i++) {
			char[] s1 = new char[100];
			for (int j = 0; j < s1.length; j++) {
				s1[j] = (char) ('a' + (char) rand.nextInt(charCount));
			}
			System.out.println(new String(s1));
		}
	}
}
