import java.util.BitSet;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Prime {
	protected static final int max = 21;
	private static BitSet bs = new BitSet(max);
	private static List primes = new ArrayList();
	public static void main(String[] args) {
		//Date start = new Date();
		// TODO Auto-generated method stub
		generatePrime(max);
		//Date end = new Date();
		int lowerP = primes.size() % 2 == 1 ? primes.size() - 2 -1 : primes.size() - 2 -2  ;
		int upperP = lowerP + primes.size() % 2 == 1 ?  2*2 : 2*2 -1;
		for(int i = lowerP; i < upperP; i++)
		{
			
		}
		
		System.out.println(primes.size());
		System.out.println(primes); 
		//System.out.println(end.getTime() - start.getTime());
	}
	static void generatePrime(int upperBound)
	{
		bs.flip(0,max);
		bs.set(0, false);
		bs.set(1);
		bs.set(2);
		primes.add(1);
		for(int i = 2; i < max; i++)
		{
			if (bs.get(i))
			{
				removeMultiples(i);
				primes.add(i);
			}
		}
	}
	static void removeMultiples(int number)
	{
		int temp = number*2;
		while(temp < max)
		{
			bs.set(temp, false);
			temp += number;
		}
	}

}
