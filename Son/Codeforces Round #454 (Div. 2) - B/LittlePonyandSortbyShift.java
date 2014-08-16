package olympic;
import java.util.*;
import java.io.*;

public class LittlePonyandSortbyShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner input =new Scanner(System.in);
		InputStream inputStream = System.in;
		InputReader reader = new InputReader(inputStream);
		int n;//n=10^5;
		n=reader.nextInt();
		int [] a= new int[n];
		int min=100000;
		int first=0;
		for(int i=0;i<n;i++)
		{
			a[i]=reader.nextInt();
			if(a[i]<=min)
			{
				min=a[i];
				first=i;
			}
		}
		for(int i=first;i>0;i--)
		{
			if(a[i]==a[i-1])
				first=i-1;
			else
				break;
		}
		int tmp=0;
		for(int i=1;i<first;i++)
			if(a[i]<a[i-1])
			{
				tmp=1;
				break;
			}
		if(tmp==0)
		{
			for(int i=first+1;i<n;i++)
				if(a[i]<a[i-1])
				{
					tmp=1;
					break;
				}
		}
		if(tmp==0 && a[n-1]>a[0] && first!=0)
			tmp=1;
		if(tmp==0)
			System.out.println((n-first)%n);
		else
			System.out.println("-1");
		}
	/******************************************************************
	 ****************************** READER*****************************
	 ******************************************************************/
	private static class InputReader {
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}


}
