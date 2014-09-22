import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A5 {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		
		int iR = 0;
		int jR = 0;
		int max = 0;
		
		int tempI= 0;
		int tempJ = 0;
		
		for(int i = 1; i<n; ++i){
			if(a[i]>a[tempJ]){
				tempJ =i;
				if(a[tempJ]-a[tempI]>a[jR]-a[iR]){
					iR = tempI;
					jR = tempJ;
				}
			}else if(a[i]<a[tempJ]){
				tempI = i;
				tempJ =i;
			}
		}
		System.out.println(iR+" "+jR);

	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
