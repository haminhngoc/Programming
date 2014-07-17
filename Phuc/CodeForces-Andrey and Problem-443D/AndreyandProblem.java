import java.util.Scanner;


public class AndreyandProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		double [] probabilities = new double[n];
		for(int i = 0; i <n; ++i){
			probabilities[i] = in.nextDouble();
		}
		System.out.println(solve(n, probabilities));
	}

	private static double solve(int n, double[] probabilities) {
		
		return n;
		
	}

}
