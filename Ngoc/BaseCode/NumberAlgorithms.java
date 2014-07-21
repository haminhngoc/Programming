import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberAlgorithms {
	
	/*****************************************************************
	 *************FACTORIZATION AND DIVISOR****************************
	 *****************************************************************/
	
	/*
	 * July 19th, 2014. Created by Ngoc
	 * 10^12 < 2*3*5*7*11*13*17*19*23*29*31*37 => Maximum 2^11 ~ 2K divisors
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
	 * July 19th, 2014. Created by Ngoc
	 * 10^12 < 2*3*5*7*11*13*17*19*23*29*31*37 => Maximum 2^11 ~ 2K divisors
	*/
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

	
	/*****************************************************************
	 * GCD & LCM *****************************************************
	 *****************************************************************/
	
	/*
	 * Find greatest common divisor
	 * Edited by Duy
	 */
	public static long gcd(long number1, long number2){
		return 0;
	}
	/*
	 * Find greatest common divisor
	 * Edited by Duy
	 */
	public static long lcm(long number1, long number2){
		return 0;
	}
	
	/*****************************************************************
	 * PRIME *********************************************************
	 *****************************************************************/
	
	/*
	 * This method is used to check prime multiple times > 10^8
	 * Edited by Phi
	 */
	public static void initPrimeList(int limit){
		// Note: what is the best method? performance and easily to re-write?
	}
	
	/*
	 * Check prime in O(0)
	 * Edited by Phi
	 */
	public static boolean isPrime(int number){
		return false;
	}
	
	/*
	 * Check if a number is prime
	 * Edited by Phi
	 */
	public static boolean isPrimeSimple(int number){
		return false;
	}
	
	/*****************************************************************
	 *********************BASE AND BIG NUMBER*************************
	 *****************************************************************/
	
	/*
	 * Check if a number is prime
	 * Edited by Phuc
	 */
	
	/*****************************************************************
	 ***********************UTILITY SECTION***************************
	 *****************************************************************/
	
	public static Comparator<Long> comparator() {
		return new Comparator<Long>() {
			public int compare(Long arg0, Long arg1) {
				return Long.compare(arg0, arg1);
			}
		};
	}
	
	
	/*****************************************************************
	 ***********************TEST SECTION*******************************
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

}
