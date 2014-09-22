import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class P458C {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "5 " + "1 2 1 2 1 2 2 1 0 0";

	public static void main(String[] args) throws Exception {
		// oj = true;
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	static void solve() {
		int n = ni();
		int MAX = 100001;

		Candidate[] candidates = new Candidate[MAX];

		for (int i = 0; i < n; i++) {
			int candidate = ni();
			int cost = ni();
			Candidate can = candidates[candidate];
			if (can == null) {
				can = candidates[candidate] = new Candidate();
			}
			can.costs.add(cost);
		}
		candidates[0].isMe = true;

		Arrays.sort(candidates, canComp);

		int noCandidate = 0;
		for (int i = MAX - 1; i >= 0; i--) {
			if (candidates[i] != null) {
				noCandidate = i + 1;
				break;
			}
		}

		for (int i = 0; i < noCandidate; i++) {
			candidates[i].costs.sort(costCompDes);
		}

		int maxVoted = candidates[noCandidate - 1].costs.size();
		int[] topDown = new int[maxVoted + 1];
		Candidate me = null;
		int meIndex;
		int meVote = me.costs.size();
		for (meIndex = noCandidate - 1; meIndex >= 0; meIndex--) {
			Candidate can = candidates[meIndex];
			if (can.isMe) {
				me = can;
				break;
			}
			for (int j = can.costs.size() - 1; j >= meVote; j--) {
				topDown[j] += can.costs.get(j);
			}
		}

		PriorityQueue<Integer> lowestCosts = new PriorityQueue<Integer>();
		for (int i = meIndex - 1; i >= 0; i--) {
			Candidate can = candidates[i];
			for (int j = can.costs.size() - 1; j >= 0; j--) {
				lowestCosts.add(can.costs.get(j));
			}
		}

		PriorityQueue<Integer> curCosts = new PriorityQueue<Integer>();
		int[] bottomUp = new int[maxVoted + 1];
		
		// Too tired to do more, I guess you have understood this idea		

		int result = 0;
		for (int i = maxVoted; i >= meIndex; i--) {
			result = Math.max(result, topDown[i] + bottomUp[i]);
		}

		System.out.println(result);
	}

	static Comparator<Integer> costCompDes = new Comparator<Integer>() {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			return -Integer.compare(arg0, arg1);
		}
	};

	static Comparator<Candidate> canComp = new Comparator<Candidate>() {
		@Override
		public int compare(Candidate arg0, Candidate arg1) {
			if (arg0 == null)
				return 1;
			if (arg1 == null)
				return -1;
			return Integer.compare(arg0.costs.size(), arg1.costs.size());
		}
	};

	static class Candidate {
		List<Integer> costs = new ArrayList<Integer>();
		boolean isMe = false;
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static void tr(Object... o) {
		if (!oj) {
			System.out.println(Arrays.deepToString(o));
		}
	}
}
