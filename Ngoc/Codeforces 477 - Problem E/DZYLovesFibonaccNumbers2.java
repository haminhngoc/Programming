import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DZYLovesFibonaccNumbers2 {

	static public long MOD = 1000000009;
	static public long[] SF;

	public static void main(String[] args) throws IOException {

		ReaderFibonacc2.Init(System.in);

		int n = ReaderFibonacc2.nextInt(); // 300K
		int m = ReaderFibonacc2.nextInt(); // 300K

		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = ReaderFibonacc2.nextInt();
		}
		long[] sa = new long[n];
		sa[0] = a[0];
		for (int i = 1; i < n; i++) {
			sa[i] = (sa[i - 1] + a[i]) % MOD;
		}

		int[][] queries = new int[m][3];
		for (int i = 0; i < m; i++) {
			queries[i][0] = ReaderFibonacc2.nextInt();
			queries[i][1] = ReaderFibonacc2.nextInt();
			queries[i][2] = ReaderFibonacc2.nextInt();
		}

		long[] F = new long[Math.max(n, 3) + 1];
		F[0] = 0; // F0
		F[1] = 1; // F1
		F[2] = 1; // F2, F3:2, F3:3
		for (int i = 3; i < n; i++) {
			F[i] = (F[i - 1] + F[i - 2]) % MOD;
		}
		SF = new long[Math.max(n, 3) + 1];
		SF[0] = 0;
		for (int i = 1; i < n; i++) {
			SF[i] = (SF[i - 1] + F[i]) % MOD;
		}

		Segment segments = new Segment(0, n, 0);
		for (int i = 0; i < m; i++) {
			int l = queries[i][1];
			int r = queries[i][2];
			if (queries[i][0] == 1) {
				segments.Break(l, r - l, 1, r - l);
			} else {
				System.out
						.println((segments.FindSum(l, r) + sa[r - l] + MOD - sa[l])
								% MOD);
			}
		}
	}
}

class Segment {
	public int Start;
	public int End;
	public long Sum;
	public int Mid;

	public Segment(int start, int end, long sum) {
		Start = start;
		End = end;
		Mid = -1;
		Sum = sum;
	}

	public Segment Left;
	public Segment Right;

	public long SumSF(int sfStart, int sfLen) {
		return (DZYLovesFibonaccNumbers2.SF[sfStart + sfLen]
				+ DZYLovesFibonaccNumbers2.MOD - DZYLovesFibonaccNumbers2.SF[sfStart])
				% DZYLovesFibonaccNumbers2.MOD;
	}

	public void Break(int midStart, int midLen, int sfStart, int sfLen) {
		Sum = (Sum + DZYLovesFibonaccNumbers2.SF[sfStart + sfLen])
				% DZYLovesFibonaccNumbers2.MOD;

		if (midLen == End - Start || midLen == 0) {
			return;
		}
		if (Mid < 0) {
			if (midStart == Start) {
				Left = new Segment(Start, midStart + midLen, SumSF(sfStart,
						sfLen)); // midLen
				Right = new Segment(midStart + midLen, End, 0);
			} else if (midStart + midLen == End) {
				Left = new Segment(Start, midStart, 0);
				Right = new Segment(midStart, End, SumSF(sfStart, sfLen));
			} else { // Start < MidStart < MidEnd < End
				if (midStart - Start > End - midStart - midLen) {
					Left = new Segment(Start, midStart, 0);
					Right = new Segment(midStart, End, SumSF(sfStart, sfLen));
					Right.Break(midStart + midLen, midLen, sfStart, sfLen);
				} else {
					Left = new Segment(Start, midStart + midLen, SumSF(sfStart,
							sfLen));
					Right = new Segment(midStart + midLen, End, 0);
					Left.Break(midStart, midLen, sfStart, sfLen);
				}
			}
		} else {
			if (midStart < Mid && midStart + midLen <= Mid) {
				Left.Break(midStart, midLen, sfStart, sfLen);
			} else if (midStart < Mid && Mid < midStart + midLen) {
				Left.Break(midStart, Mid - midStart, sfStart,
						Math.min(sfLen, Mid - midStart));
				Right.Break(midStart + midLen, midStart + midLen - Mid, sfLen
						- Mid + midStart < 0 ? 0 : sfStart + Mid - midStart,
						Math.max(0, sfLen - Mid + midStart));
			} else {
				Right.Break(midStart, midLen, sfStart, sfLen);
			}
		}
	}

	public long FindRemain(int i, Boolean left) {
		int j = i - Start;
		if (Mid < 0) {
			return left ? DZYLovesFibonaccNumbers2.SF[j]
					: (DZYLovesFibonaccNumbers2.SF[End - Start]
							+ DZYLovesFibonaccNumbers2.MOD - DZYLovesFibonaccNumbers2.SF[j])
							% DZYLovesFibonaccNumbers2.MOD;
		} else {
			if (i < Mid) {
				return Left.FindRemain(i, left);
			} else {
				return Right.FindRemain(i, left);
			}
		}
	}

	public long FindSum(int start, int end) {
		return Sum - FindRemain(start, true) - FindRemain(end, false);
	}
}

class ReaderFibonacc2 {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}