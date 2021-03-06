import java.util.*;

public class DZYLovesSequences {

	// sort suffixes of S in O(n*log(n))
	public static int[] suffixArray(CharSequence S) {
		int n = S.length();
		Integer[] order = new Integer[n];
		for (int i = 0; i < n; i++)
			order[i] = n - 1 - i;

		// stable sort of characters
		//Arrays.sort(order, (a,b) -> S.charAt(a).compareTo(S.charAt(b)));

		int[] sa = new int[n];
		int[] classes = new int[n];
		for (int i = 0; i < n; i++) {
			sa[i] = order[i];
			classes[i] = S.charAt(i);
		}
		// sa[i] - suffix on i'th position after sorting by first len characters
		// classes[i] - equivalence class of the i'th suffix after sorting by first len characters

		for (int len = 1; len < n; len *= 2) {
			int[] c = classes.clone();
			for (int i = 0; i < n; i++) {
				// condition sa[i - 1] + len < n simulates 0-symbol at the end of the string
				// a separate class is created for each suffix followed by simulated 0-symbol
				classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
			}
			// Suffixes are already sorted by first len characters
			// Now sort suffixes by first len * 2 characters
			int[] cnt = new int[n];
			for (int i = 0; i < n; i++)
				cnt[i] = i;
			int[] s = sa.clone();
			for (int i = 0; i < n; i++) {
				// s[i] - order of suffixes sorted by first len characters
				// (s[i] - len) - order of suffixes sorted only by second len characters
				int s1 = s[i] - len;
				// sort only suffixes of length > len, others are already sorted
				if (s1 >= 0)
					sa[cnt[classes[s1]]++] = s1;
			}
		}
		return sa;
	}

	// sort rotations of S in O(n*log(n))
	public static int[] rotationArray(CharSequence S) {
		int n = S.length();
		Integer[] order = new Integer[n];
		for (int i = 0; i < n; i++)
			order[i] = i;
<<<<<<< HEAD
		//Arrays.sort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));
=======
	//	Arrays.sort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));
>>>>>>> 077728ba771defb07b906ed45bc48aaa8a6e72f5
		int[] sa = new int[n];
		int[] classes = new int[n];
		for (int i = 0; i < n; i++) {
			sa[i] = order[i];
			classes[i] = S.charAt(i);
		}
		for (int len = 1; len < n; len *= 2) {
			int[] c = classes.clone();
			for (int i = 0; i < n; i++)
				classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && c[(sa[i - 1] + len / 2) % n] == c[(sa[i] + len / 2) % n] ? classes[sa[i - 1]] : i;
			int[] cnt = new int[n];
			for (int i = 0; i < n; i++)
				cnt[i] = i;
			int[] s = sa.clone();
			for (int i = 0; i < n; i++) {
				int s1 = (s[i] - len + n) % n;
				sa[cnt[classes[s1]]++] = s1;
			}
		}
		return sa;
	}

	// longest common prefixes array in O(n)
	public static int[] lcp(int[] sa, CharSequence s) {
		int n = sa.length;
		int[] rank = new int[n];
		for (int i = 0; i < n; i++)
			rank[sa[i]] = i;
		int[] lcp = new int[n - 1];
		for (int i = 0, h = 0; i < n; i++) {
			if (rank[i] < n - 1) {
				for (int j = sa[rank[i] + 1]; Math.max(i, j) + h < s.length() && s.charAt(i + h) == s.charAt(j + h); ++h)
					;
				lcp[rank[i]] = h;
				if (h > 0)
					--h;
			}
		}
		return lcp;
	}

	// Usage example
	public static void main(String[] args) {
		String s1 = "abcab";
		int[] sa1 = suffixArray(s1);

		// print suffixes in lexicographic order
		for (int p : sa1)
			System.out.println(s1.substring(p));

		System.out.println("lcp = " + Arrays.toString(lcp(sa1, s1)));

		// random test
	/*	Random rnd = new Random(1);
		for (int step = 0; step < 100000; step++) {
			int n = rnd.nextInt(100) + 1;
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < n; i++)
				s.append((char) ('\1' + rnd.nextInt(10)));
			int[] sa = suffixArray(s);
			int[] ra = rotationArray(s.toString() + '\0');
			int[] lcp = lcp(sa, s);
			for (int i = 0; i + 1 < n; i++) {
				String a = s.substring(sa[i]);
				String b = s.substring(sa[i + 1]);
				if (a.compareTo(b) >= 0
						|| !a.substring(0, lcp[i]).equals(b.substring(0, lcp[i]))
						|| (a + " ").charAt(lcp[i]) == (b + " ").charAt(lcp[i])
						|| sa[i] != ra[i + 1])
					throw new RuntimeException();
			}
		}
<<<<<<< HEAD
		System.out.println("Test passed");	
=======
		System.out.println("Test passed");
		
>>>>>>> 077728ba771defb07b906ed45bc48aaa8a6e72f5
		int[] arr = new int[100000];
		int n;
		int left = 0, mid = 0;
		int longest = 2;
		
		int[] longest = new int[100000];
		int n, max = 2;
		int lastEnd = 0;
		int hasMistakeAt = 0;
		int longestSub = 2;
		
>>>>>>> 3163f2619b87728cf8eeb74f07acd284ab21eaac
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		if (arr[0] > arr[1])
		{
			mid = 1;
		}
		
		for (int i = 2; i < n; i++)
		{
			arr[i] = sc.nextInt();
			if (arr[i] < arr[i-1] && arr[i] >= arr[i-2]) // level 1
			{
				if (mid != left)
				{
					longest = longest > i - left + 1 ? longest : i -left + 1;
					left = mid;
					mid = i;
				}
				else
				{
					mid = i;
				}
			}
			if (arr[i] < arr[i-2]) // level 2
			{
				longest = longest > i - left + 1 ? longest : i -left + 1;
				left = i -1;
				mid = i - 1;
			}
		}
<<<<<<< HEAD
		System.out.println(longest);
=======
		System.out.println(max);*/
<<<<<<< HEAD
=======
		
>>>>>>> 077728ba771defb07b906ed45bc48aaa8a6e72f5
	}
}
