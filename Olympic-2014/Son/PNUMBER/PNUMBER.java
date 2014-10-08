import java.util.Scanner;


public class PNUMBER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		boolean[] prime = new boolean[200001];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= 200000; i++)
			for (int j = 2; j * i <=200000; j++) {
				prime[i * j] = true;

			}
		int a,b;//a<b<=200000
		a=reader.nextInt();
		b=reader.nextInt();
		for(int i=a;i<=b;i++)
			if(prime[i]==false)
				System.out.println(i);

	}

}
