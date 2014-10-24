import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NumberAlgorithms {

	/*****************************************************************
	 ************* BIG INTEGET MODULAR ****************************
	 *****************************************************************/

	static long powerModular(long X, long p, long BASE) {

		if (p == 0) {
			return 1;
		}

		if (p == 1) {
			return X % BASE;
		}

		long result = powerModular(X, p >> 1, BASE);
		result = (result * result) % BASE;

		if ((p & 0x1) == 1) {
			result = (result * X) % BASE;
		}
		return result;
	}

	// http://docs.oracle.com/javase/6/docs/api/java/math/BigInteger.html
	// 4 times slower than powerModular
	static long powerModularEx(long X, long p, long BASE) {
		return BigInteger.valueOf(X).modPow(BigInteger.valueOf(p), BigInteger.valueOf(BASE)).longValue();

	}

	// http://rosettacode.org/wiki/Modular_inverse#Java
	// http://en.wikipedia.org/wiki/Modular_multiplicative_inverse
	// http://docs.oracle.com/javase/6/docs/api/java/math/BigInteger.html
	static int nCr(int n, int k, int BASE) {

		if (k > n || k < 0) {
			return -1; // Invalid
		}

		long result = 1;

		if (k > n - k) {
			k = n - k;
		}
		BigInteger base = BigInteger.valueOf(BASE);

		for (int i = 1; i <= k; i++) {
			result *= BigInteger.valueOf(i).modInverse(base).intValue();
			result *= (n - i + 1);
			result /= BASE;
		}

		return (int) result;
	}

	// Good news: k = 10^5 => run in 200ms
	// BASE should be a prime, for e.g 10^9 + 7, 10^9 + 9...
	static int[] nCrAll(int n, int k, int BASE) {

		if (k > n || k < 0) {
			return null; // Invalid
		}

		long temp = 1;
		int[] result = new int[k + 1];
		result[0] = (int) temp;

		BigInteger base = BigInteger.valueOf(BASE);
		for (int i = 1; i <= k; i++) {
			temp *= BigInteger.valueOf(i).modInverse(base).intValue();
			temp %= BASE;
			temp *= (n - i + 1);
			temp %= BASE;

			result[i] = (int) temp;
		}

		return result;
	}

	/*****************************************************************
	 ************* COMBINATORY ****************************
	 *****************************************************************/

	// n should be less than 10^4
	static int[][] getPascalTriagle(int n, int BASE) {
		// 1 1
		// 1 2 1
		// 1 3 3 1
		// 1 4 6 4 1
		int[][] result = new int[n][];
		result[0] = new int[] { 1, 1 };
		for (int i = 1; i < n; i++) {
			int[] rowi = result[i] = new int[i + 2];
			rowi[0] = rowi[i + 1] = 1;
			int[] rowi1 = result[i - 1];
			for (int j = 1; j < i + 1; j++) {
				rowi[j] = (rowi1[j - 1] + rowi1[j]) % BASE;
			}
		}
		return result;
	}

	// n should be less than 10^4 (200ms)
	static int[] nCrAll_small(int n, int BASE) {
		if (n < 1) {
			return null;
		}
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 1; i < n; i++) {
			int pre = result[0];
			for (int j = 1; j < i + 1; j++) {
				int temp = result[j];
				result[j] = (pre + result[j]) % BASE;
				pre = temp;
			}
			result[i + 1] = 1;
		}
		return result;
	}

	/*****************************************************************
	 ************* FACTORIZATION AND DIVISOR****************************
	 *****************************************************************/

	/*
	 * July 19th, 2014. Created by Ngoc 10^12 < 2*3*5*7*11*13*17*19*23*29*31*37 => Maximum 2^11 ~ 2K divisors
	 */
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

	/*
	 * July 19th, 2014. Created by Ngoc
	 */
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

	/*
	 * July 19th, 2014. Created by Ngoc 10^12 < 2*3*5*7*11*13*17*19*23*29*31*37 => Maximum 2^11 ~ 2K divisors
	 */
	public static Map<Long, List<Long>> getDivisorsOfDivisor(long x, List<Long> divisors) {

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

	public static List<Integer> getDivisors(long x, int[] primes) {
		List<Integer> divisors = new ArrayList<Integer>();
		divisors.add(1);

		int pi = 0;
		int p = primes[pi++];
		int sq = (int) (Math.round(Math.sqrt(x)) + 1);
		while (p < sq) {

			int pPower = 1;
			int cur = divisors.size();
			while (x % p == 0) {
				pPower *= p;
				x /= p;

				for (int i = 0; i < cur; i++) {
					divisors.add(divisors.get(i) * pPower);
				}
			}

			if (pPower > 0) {
				sq = (int) (Math.round(Math.sqrt(x)) + 1);
			}
		}

		if (x > 1) {
			int cur = divisors.size();
			for (int i = 0; i < cur; i++) {
				divisors.add(divisors.get(i) * (int) x);
			}
		}

		return divisors;
	}

	public static int[] getDivisors_Simple(int n) {
		List<Integer> divisors = new ArrayList<>();
		for (int d = 1; d * d <= n; d++)
			if (n % d == 0) {
				divisors.add(d);
				if (d * d != n) {
					divisors.add(n / d);
				}
			}
		int[] result = new int[divisors.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = divisors.get(i);
		}
		Arrays.sort(result);
		return result;
	}

	/*****************************************************************
	 * GCD & LCM *****************************************************
	 *****************************************************************/

	/*
	 * Find greatest common divisor Edited by
	 */
	public static long gcd(long a, long b) {
		if (a > b) {
			long temp = a;
			a = b;
			b = temp;
		}
		while (a > 0) {
			long temp = a;
			a = b % a;
			b = temp;
		}
		return b;
	}

	/*
	 * Find greatest common divisor Edited by
	 */
	public static long lcm(long number1, long number2) {
		return number1 / gcd(number1, number2) * number2;
	}

	/*****************************************************************
	 * PRIME *********************************************************
	 *****************************************************************/

	/*
	 * This method is used to check prime multiple times > 10^8 Edited by
	 */
	public static boolean[] getPrimeMap(int limit) {
		boolean[] map = new boolean[limit + 1];
		Arrays.fill(map, 2, limit + 1, true);
		for (int i = 2; i * i <= limit; i++) {
			if (map[i]) {
				for (int j = i * i; j <= limit; j += i) {
					map[j] = false;
				}
			}
		}
		return map;
	}

	public static int[] getPrimes(int limit) {
		boolean[] map = getPrimeMap(limit);

		int[] primes = new int[limit + 1];
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			if (map[i]) {
				primes[cnt++] = i;
			}
		}

		return Arrays.copyOf(primes, cnt);
	}

	/*
	 * Check prime in O(0) Edited by
	 */
	public static boolean isPrime(int number) {
		return false;
	}

	/*
	 * Check if a number is prime Edited by
	 */
	public static boolean isPrimeSimple(int number) {
		return false;
	}

	/*****************************************************************
	 ********************* BASE AND BIG NUMBER*************************
	 *****************************************************************/

	/*
	 * Check if a number is prime Edited by
	 */

	/*****************************************************************
	 *********************** UTILITY SECTION***************************
	 *****************************************************************/

	public static Comparator<Long> comparator() {
		return new Comparator<Long>() {
			public int compare(Long arg0, Long arg1) {
				return Long.compare(arg0, arg1);
			}
		};
	}

	/*****************************************************************
	 *********************** TEST SECTION*******************************
	 *****************************************************************/

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

	public static void main(String[] args) {

		long start, end;

		int A5 = 100000; // 10^5
		int A6 = 1000000; // 10^6
		int A9 = 1000000000; // 10^9
		Random rand = new Random();

		if (true) {
			start = System.currentTimeMillis();
			int[] temp = nCrAll(A5, A5, A9 + 9);
			end = System.currentTimeMillis();
			System.out.println("nCrAll(A5, A5, A9+9): " + (end - start));

			int n1000 = 1000;
			int[][] pascal1000 = getPascalTriagle(n1000, A9 + 9);
			int[] nCr1000Small = nCrAll_small(n1000, A9 + 9);
			int[] nCr100 = nCrAll(n1000, n1000, A9 + 9);

			boolean ok = true;
			for (int i = 0; i <= n1000; i++) {
				ok &= (nCr100[i] == nCr1000Small[i] && nCr100[i] == pascal1000[n1000 - 1][i]);
			}

			System.out.println("getPascalTriagle vs. nCr1000Small vs. nCr100: " + ok);

			start = System.currentTimeMillis();
			nCr1000Small = nCrAll_small(10000, A9 + 9);
			end = System.currentTimeMillis();
			System.out.println("nCr1000Small 10K: " + (end - start));
		}

		// TEST powerModular vs. powerModularEx:
		if (false) {
			start = System.currentTimeMillis();
			for (int i = 0; i < A5; i++) {
				long temp = powerModular(rand.nextInt(A9), rand.nextInt(A9), rand.nextInt(A9));
			}
			end = System.currentTimeMillis();
			System.out.println("powerModular: " + (end - start));

			start = System.currentTimeMillis();
			for (int i = 0; i < A5; i++) {
				long tempEx = powerModularEx(rand.nextInt(A9), rand.nextInt(A9), rand.nextInt(A9));
			}
			end = System.currentTimeMillis();
			System.out.println("powerModularEx: " + (end - start));

			boolean ok = true;
			start = System.currentTimeMillis();
			for (int i = 0; i < A5; i++) {
				long X = rand.nextInt(A9);
				long p = rand.nextInt(A9);
				long BASE = rand.nextInt(A9);
				long temp = powerModularEx(X, p, BASE);
				long tempEx = powerModularEx(X, p, BASE);
				ok &= (temp == tempEx);
			}
			end = System.currentTimeMillis();
			System.out.println("powerModular vs. powerModularEx: " + ok + " in " + (end - start));
		}
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