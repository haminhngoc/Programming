import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.StringBuffer;

import sun.font.CreatedFontTracker;

public class Divisors {
	static long X; // 10^12
	static long k; // 10^18
	static long[] divisorIndex;
	static long[] divisors;

	public static void main(String[] args) throws IOException {
		initReader();
		logTime("");
		while (true) {

			readInput();
			// logTime("readInput");

			solve();
			// logTime("solution");

			break;
		}
	}

	public static int solve() {

		List<Long> divisors = new ArrayList<Long>();
		Map<Long, List<Long>> divisorMap = getDivisorsOfDivisor(X, divisors);

		Status[] stack = new Status[100001];

		int limit = 100000;
		int ik = (int) Math.min((long) limit, k);

		stack[0] = new Status(X, -1);
		int index = 0;
		int printed = 0;
		StringBuffer stringBuffer = new StringBuffer();
		while (printed < limit && index >= 0) {
			Status current = stack[index];
			if (current.number == 1) {
				printed++;
				// System.out.print(1 + (printed == limit ? "" : " "));
				stringBuffer.append(1 + (printed == limit ? "" : " "));
				index--;
				continue;
			}
			if (index == ik) {
				printed++;
				// System.out
				// .print(current.number + (printed == limit ? "" : " "));
				stringBuffer.append(current.number
						+ (printed == limit ? "" : " "));
				index--;
				continue;
			}
			List<Long> children = divisorMap.get(current.number);

			if (children.size() == 2 && current.index == -1) {
				int need = Math.min(ik - index, limit - printed);
				String newString = initString('1', need);
				printed += need;
				stringBuffer.append(newString);
				if (printed < limit) {
					stringBuffer.append(current.number);
					printed++;
				}
				index--;
				continue;
			}
			if (current.index < children.size() - 1) {
				current.index++;
				long childDivisor = children.get(current.index);
				index++;
				stack[index] = new Status((long) childDivisor, -1);
			} else {
				index--;
			}
		}
		System.out.print(stringBuffer.toString());
		return 0;
	}

	// 10^12 < 2*3*5*7*11*13*17*19*23*29*31*37 => Maximum 2^11 ~ 2K divisors
	public static List<NumberFactor> fatorization(long x) {
		long sq = Math.round(Math.sqrt(x)) + 1; // 10 ^ 6
		List<NumberFactor> list = new ArrayList<NumberFactor>();
		int i = 2;
		NumberFactor current = null;
		while (i < sq && x > 1) {
			if (x % i == 0) {
				if (current == null) {
					current = new NumberFactor(i, 0);
					list.add(current);
				}
				current.base++;
				x = x / i;
			} else {
				current = null;
				i++;
			}
		}
		if (x > 1) {
			list.add(new NumberFactor(x, 1));
		}
		return list;
	}

	public static List<Long> getDivisors(long x) {
		List<Long> divisors = new ArrayList<Long>();
		divisors.add((long) 1);

		List<NumberFactor> factors = fatorization(x);

		for (int i = 0; i < factors.size(); i++) {
			NumberFactor factor = factors.get(i);
			int preCount = divisors.size();
			long item = 1;
			for (int base = 1; base <= factor.base; base++) {
				item *= factor.prime;
				for (int j = 0; j < preCount; j++) {
					divisors.add(divisors.get(j) * item);
				}
			}
		}
		divisors.sort(comparator());
		return divisors;
	}

	public static Map<Long, List<Long>> getDivisorsOfDivisor(long x,
			List<Long> divisors) {

		Map<Long, List<Long>> divisorMap = new HashMap<Long, List<Long>>();
		List<Long> firstList = new ArrayList<Long>();
		firstList.add((long) 1);
		divisorMap.put((long) 1, firstList);

		divisors.add((long) 1);

		List<NumberFactor> factors = fatorization(x);

		for (int i = 0; i < factors.size(); i++) {
			NumberFactor factor = factors.get(i);
			int preCount = divisors.size();
			long item = 1;
			for (int base = 1; base <= factor.base; base++) {
				item *= factor.prime;
				for (int j = 0; j < preCount; j++) {
					long oldDivisor = divisors.get(j);
					long newDivisor = oldDivisor * item;
					divisors.add(newDivisor);

					List<Long> oldChildren = divisorMap.get(oldDivisor);
					List<Long> newChildren = new ArrayList<Long>();
					newChildren.addAll(oldChildren);
					for (int u = 0; u < oldChildren.size(); u++) {
						long newItem = 1;
						while (newItem < item) {
							newItem *= factor.prime;
							newChildren.add(oldChildren.get(u) * newItem);
						}
					}
					newChildren.sort(comparator());
					divisorMap.put(newDivisor, newChildren);
				}
			}
		}

		return divisorMap;
	}

	public static Comparator<Long> comparator() {
		return new Comparator<Long>() {
			public int compare(Long arg0, Long arg1) {
				return Long.compare(arg0, arg1);
			}
		};
	}

	public static void testFactorization(long x) {
		List<NumberFactor> factors = fatorization(x);
		for (int i = 0; i < factors.size(); i++) {
			NumberFactor factor = factors.get(i);
			System.out.println(factor.prime + " " + factor.base);
		}
		System.out.println("");
	}

	public static void testAllDivisor(long x) {
		List<Long> divisors0 = getDivisors(x);
		System.out.print(divisors0.size() + ":    ");
		for (int i = 0; i < divisors0.size(); i++) {
			System.out.print(divisors0.get(i) + " ");
		}
		System.out.println("");
	}

	public static void testMap(long x) {
		List<Long> divisors = new ArrayList<Long>();
		Map<Long, List<Long>> divisorMap = getDivisorsOfDivisor(x, divisors);

		int total = 0;
		for (int i = 0; i < divisors.size(); i++) {
			long divisor = divisors.get(i);
			List<Long> children = divisorMap.get(divisor);
			total += children.size();
		}
		System.out.println(total);

		for (int i = 0; i < divisors.size(); i++) {
			long divisor = divisors.get(i);
			System.out.print(divisor + ": ");
			List<Long> children = divisorMap.get(divisor);
			for (int j = 0; j < children.size(); j++) {
				System.out.print(children.get(j) + " ");
			}
			System.out.println("");
		}
	}

	public static void readInput() throws IOException {
		X = nextLong();
		k = nextLong();
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	public static void initReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static String nextLine() throws IOException {
		return reader.readLine();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	/*****************************************************************
	 ******************** TIME UTILITIES *******************************
	 *****************************************************************/

	static long startTime = 0;
	static long preLogTime = 0;

	static void logTime(String lable) {
		long current = System.currentTimeMillis();
		if (startTime != 0) {
			println(lable, " - From start:", (current - startTime),
					"- From previous:", (current - preLogTime));
		} else {
			startTime = current;
		}
		preLogTime = current;
	}

	/*****************************************************************
	 ******************** READ UTILITIES *******************************
	 *****************************************************************/

	public static int[] readLine(int n) throws IOException {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = nextInt();
		}
		return result;
	}

	public static long[] readLineLong(int n) throws IOException {
		long[] result = new long[n];
		for (int i = 0; i < n; i++) {
			result[i] = nextLong();
		}
		return result;
	}

	public static int[][] readMatrix(int row, int column) throws IOException {
		int[][] result = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result[i][j] = nextInt();
			}
		}
		return result;
	}

	public static long[][] readMatrixLong(int row, int column)
			throws IOException {
		long[][] result = new long[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result[i][j] = nextLong();
			}
		}
		return result;
	}

	/*****************************************************************
	 ******************** PRINT UTILITIES *******************************
	 *****************************************************************/

	public static void print(Object... obj) {
		System.out.print(join(obj, " "));
	}

	public static void println(Object... obj) {
		System.out.println(join(obj, " "));
	}

	public static String join(Object[] objs) {
		return join(objs, " ");
	}

	public static String join(int[] objs) {
		return join(objs, " ");
	}

	public static String join(long[] objs) {
		return join(objs, " ");
	}

	public static String join(Object[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static String join(int[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static String join(long[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			println(join(matrix[i]));
		}
	}

	public static void printMatrix(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			println(join(matrix[i]));
		}
	}

	/*****************************************************************
	 *************** ARRAY AND STRING UTILITIES **********************
	 *****************************************************************/

	public static int[] initArray(int value, int length) {
		int[] result = new int[length];
		Arrays.fill(result, value);
		return result;
	}

	public static long[] initArray(long value, int length) {
		long[] result = new long[length];
		Arrays.fill(result, value);
		return result;
	}

	public static String initString(char c, int length) {
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		return new String(chars);
	}
}

class NumberFactor {
	long prime;
	int base;

	public NumberFactor(long prime, int base) {
		this.prime = prime;
		this.base = base;
	}
}

class Status {
	long number;
	int index;

	public Status(long number, int index) {
		this.number = number;
		this.index = index;
	}
}

/*
 * class NumberDivisor { long number; List<Long> divisors = new
 * ArrayList<Long>(); }
 */

/*
 * List<NumberFactor> factors = fatorization(X); for (int i = 0; i <
 * factors.size(); i++) { NumberFactor factor = factors.get(i);
 * System.out.println(factor.prime + " " + factor.base); }
 * System.out.println("");
 */

/*
 * List<Long> divisors0 = getDivisors(X); System.out.print(divisors0.size());
 * for (int i = 0; i < divisors0.size(); i++) {
 * System.out.print(divisors0.get(i) + " "); } System.out.println("");
 */

/*
 * int total = 0; for (int i = 0; i < divisors.size(); i++) { long divisor =
 * divisors.get(i); List<Long> children = divisorMap.get(divisor); total +=
 * children.size(); } System.out.println(total);
 * 
 * for (int i = 0; i < divisors.size(); i++) { long divisor = divisors.get(i);
 * System.out.print(divisor + ": "); List<Long> children =
 * divisorMap.get(divisor); for (int j = 0; j < children.size(); j++) {
 * System.out.print(children.get(j) + " "); } System.out.println(""); }
 */