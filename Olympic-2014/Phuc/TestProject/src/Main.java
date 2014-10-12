public class Main {

	public static void main(String[] args) {
		long max = Long.MIN_VALUE;
		for (long i = (long) 1e10-40000; i < 1e10-30000; ++i) {
			int end = (int) Math.sqrt(i);
			long count = 0;
			for (int j = 2; j <= end; ++j) {
				if (i % j == 0) {
					count++;
					if (i / j != j) {
						count++;
					}
				}
			}

			max = Math.max(max, count);
		}
		
		System.out.println(max);

	}
}
