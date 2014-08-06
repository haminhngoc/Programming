import java.util.*;

public class Ng_Array {
	static boolean test = true;

	// Longest Common Sub-Sequence
	static int LCS(int[] source, int[] target) {
		return 0;
	}

	// Longest increase sub-sequence
	static int LongestIncrease(int[] source) {
		int maxLen = 1;
		int maxPos = 0;
		int pre = -1;
		int len = source.length;
		for (int i = 0; i < len - 1; i++) {
			if (pre < 0 && source[i] <= source[i + 1]) {
				pre = i;
			} else if (pre >= 0 && source[i] > source[i + 1]) {
				if (maxLen < i - pre + 1) {
					maxLen = i - pre + 1;
					maxPos = pre;
				}
				pre = -1;
			} else if (pre >= 0 && i == len - 2 && source[i] <= source[i + 1]) {
				if (maxLen < i + 1 - pre + 1) {
					maxLen = i + 1 - pre + 1;
					maxPos = pre;
				}
				pre = -1;
			}
		}
		for (int i = 0; i < len; i++) {
			if (i == maxPos)
				printTest("(");
			printTest(source[i] + " ");
			if (i == maxPos + maxLen - 1)
				printTest(")");
		}
		printTestLn("");
		return maxLen;
	}

	// Maximum increase sub-sequence
	static int MaximumIncrease(int[] source) {
		int max = 0;
		int maxLen = 1;
		int maxPos = 0;
		int pre = -1;
		int len = source.length;
		for (int i = 0; i < len - 1; i++) {
			if (pre < 0 && source[i] <= source[i + 1]) {
				pre = i;
			} else if (pre >= 0 && source[i] > source[i + 1]) {
				if (max < source[i] - source[pre]) {
					max = source[i] - source[pre];
					maxPos = pre;
					maxLen = i - pre + 1;
				}
				pre = -1;
			} else if (pre >= 0 && i == len - 2 && source[i] <= source[i + 1]) {
				if (max < source[i + 1] - source[pre]) {
					max = source[i + 1] - source[pre];
					maxPos = pre;
					maxLen = i + 1 - pre + 1;
				}
				pre = -1;
			}
		}
		for (int i = 0; i < len; i++) {
			if (i == maxPos)
				printTest("(");
			printTest(source[i] + " ");
			if (i == maxPos + maxLen - 1)
				printTest(")");
		}
		printTestLn(" = " + max);
		return max;
	}

	// Maximum Bottom to Top
	static int MBT(int[] source) {
		int len = source.length;
		if (len == 0)
			return 0;

		int cur = -1;
		int[] topIndexes = new int[len];
		int[] bottomIndexes = new int[len];

		int pre = -1;
		for (int i = 0; i < len - 1; i++) {
			if (pre < 0 && source[i] <= source[i + 1]) {
				pre = i;
			} else if (pre >= 0 && source[i] > source[i + 1]) {
				cur = pushBT(source, topIndexes, bottomIndexes, cur + 1, i, pre);
				pre = -1;
			} else if (pre >= 0 && i == len - 2 && source[i] <= source[i + 1]) {
				cur = pushBT(source, topIndexes, bottomIndexes, cur + 1, i + 1,
						pre);
				pre = -1;
			}
		}

		int maxCur = -1;
		int maxValue = 0;

		for (int i = 0; i <= cur; i++) {
			int value = source[topIndexes[i]] - source[bottomIndexes[i]];
			if (maxValue < value) {
				maxValue = value;
				maxCur = i;
			}
		}

		for (int i = 0; i < len; i++) {
			if (maxCur >= 0 && i == bottomIndexes[maxCur])
				printTest("(");
			printTest(source[i] + " ");
			if (maxCur >= 0 && i == topIndexes[maxCur])
				printTest(")");
		}
		printTestLn(" = " + maxValue);

		return maxValue;
	}

	static int pushBT(int[] source, int[] topIndexes, int[] bottomIndexes,
			int pos, int topIndex, int bottomIndex) {
		if (pos < 0) {
			pos = 0;
		}
		topIndexes[pos] = topIndex;
		bottomIndexes[pos] = bottomIndex;
		while (pos > 0) {
			int prePos = pos - 1;
			int preTop = source[topIndexes[prePos]];
			int preBottom = source[bottomIndexes[prePos]];

			int top = source[topIndex];
			int bottom = source[bottomIndex];

			if (preTop < top && preBottom < bottom) {
				topIndexes[prePos] = topIndex;
				pos--;
			} else {
				break;
			}
		}
		return pos;
	}

	// Maximum Bottom to Top or Top to Bottom
	static int MBTATB(int[] source) {
		return 0;
	}

	// Maximum Sum of sub-sequence
	static int MSS(int[] source) {

		int len = source.length;
		if (len == 0)
			return 0;

		int[] sumSource = new int[len + 1];
		len++;
		int maxValue = source[0];
		for (int i = 0; i < len - 1; i++) {
			if (maxValue < source[i])
				maxValue = source[i];
			sumSource[i + 1] = sumSource[i] + source[i];
		}

		int cur = -1;
		int[] topIndexes = new int[len];
		int[] bottomIndexes = new int[len];

		int pre = -1;
		for (int i = 0; i < len - 1; i++) {
			if (pre < 0 && sumSource[i] <= sumSource[i + 1]) {
				pre = i;
			} else if (pre >= 0 && sumSource[i] > sumSource[i + 1]) {
				cur = pushBT(sumSource, topIndexes, bottomIndexes, cur + 1, i,
						pre);
				pre = -1;
			} else if (pre >= 0 && i == len - 2
					&& sumSource[i] <= sumSource[i + 1]) {
				cur = pushBT(sumSource, topIndexes, bottomIndexes, cur + 1,
						i + 1, pre);
				pre = -1;
			}
		}

		int maxCur = -1;
		int maxIncrease = cur < 0 ? maxValue : 0;

		for (int i = 0; i <= cur; i++) {
			int value = sumSource[topIndexes[i]] - sumSource[bottomIndexes[i]];
			if (maxIncrease < value) {
				maxIncrease = value;
				maxCur = i;
			}
		}

		for (int i = 0; i < len; i++) {
			if (maxCur >= 0 && i == bottomIndexes[maxCur])
				printTest("(");
			printTest(sumSource[i] + " ");
			if (maxCur >= 0 && i == topIndexes[maxCur])
				printTest(")");
		}
		printTestLn(" = " + maxIncrease);

		return maxIncrease;
	}

	public static void main(String[] args) {
		int[][] samples = new int[][] { { 2, -1, 2, -1, 2, -2, 1, -1 },
				{ -1, 2, -1, 2, -1, 2, -2, 1, -1 },
				{ -2, -2, -3, -1, -1, -1, -1, -1 },
				{ 2, -1, -1, 3, 2, -5, 1, 3, 4, -9, 1, 3 }, {}, { 1 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 1, 1, 1, 1, 2, 2, 3 },
				{ 1, 2, 1, 2, 1, 2 }, { 2, 1, 0, 0, 2, 1, 2, 3, 4, 5, 6 },
				{ 2, 1, 0, 0, 9, 1, 2, 3, 4, 5, 6, 5 },
				{ 2, -1, -1, 3, 2, -5, 1, 3, 4, -9, 1, 3 },
				{ 2, -1, -1, 3, 2, -5, 1, 3, 4, -9, 1, 13 },
				{ -1, 1, 1, 1, 1, 1, -9, 3, 4, 5, -2, -3, -3 },
				{ -1, 1, 1, 1, 1, 1, -9, 3, 4, 5, -2, -3, -3, 7, 8, 9, 3 },
				{ 2, -1, 2, -1, -1, 2, 1, -1 }, { 2, -1, 2, -1, 2, -2, 1, -1 },
				{ 2, 1, 0, -1, -2, -3 } };

		// for (int i = 0; i < samples.length; i++) {
		// int[] source = samples[i];
		// LongestIncrease(source);
		// }
		// printTestLn("-------------------");
		// for (int i = 0; i < samples.length; i++) {
		// int[] source = samples[i];
		// MaximumIncrease(source);
		// }

		// printTestLn("-------------------");
		// for (int i = 0; i < samples.length; i++) {
		// int[] source = samples[i];
		// MBT(source);
		// }

		// printTestLn("-------------------");
		// for (int i = 0; i < samples.length; i++) {
		// int[] source = samples[i];
		// MSS(source);
		// }

		printTestLn("-------------------");
		for (int i = 0; i < samples.length; i++) {
			int[] source = samples[i];
			MSS(source);
		}

		printTestLn("-------------------");
		int[] test1 = new int[100000];
		test = false;
		for (int i = 0; i < test1.length; i++) {
			test1[i] = (int) Math.round(Math.random() * 10000 - 2000);
		}
		int maxValue = MBT(test1);
		System.out.println(maxValue);

		System.out.println("---------END----------");

		// int maxValue = LongestIncrease(test1);
		// System.out.println(maxValue);
		// maxValue = MaximumIncrease(test1);
		// System.out.println(maxValue);
	}

	public static void printTest(Object... obj) {
		if (!test)
			return;
		System.out.print(join(obj, " "));
	}

	public static void printTestLn(Object... obj) {
		if (!test)
			return;
		System.out.println(join(obj, " "));
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

}
