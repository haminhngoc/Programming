import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.InputStream;

public class Mian2250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n, p;// n=50000,p=10^9
		n = in.nextInt();
		p = in.nextInt();
		Random rd = new Random();
		int[] a = new int[n];
		int [] sum= new int [n];
		for (int i = 0; i < n; i++)
		{
			a[i] = in.nextInt();
			//a[i]=rd.nextInt(50);
		}
		sum[0]=a[0];
		for (int i = 1; i < n; i++)
		{
			sum[i] =sum[i-1]+a[i];
			System.out.println(sum[i]);
	
		}
		int max=-1;
		if(sum[n-1]>=p)
			System.out.println(n);
		else
		{	
			int s=0;
			int count=0;
			int index=-1;
			for(int i=0;i<n;i++)
			{
				
			}
				
		}
		

	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}
