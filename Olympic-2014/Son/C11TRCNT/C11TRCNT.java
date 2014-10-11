import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;;

class C11TRCNT {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n =in.nextInt();
		//Random rd = new Random();
		point[] p = new point[n];
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			point tmp = new point();
			tmp.x = in.nextInt();
			tmp.y = in.nextInt();
			//tmp.x=rd.nextLong();
			//tmp.y=rd.nextLong();
			
			p[i] = tmp;

		}
		int result = 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++) {
					if (Check(p[i], p[j], p[k]) == false) {
						count[i]++;
						count[j]++;
						count[k]++;
						//System.out.println(i+" "+j+" "+k);
					} else
						result++;

				}
		// System.out.println(result);
		int index = 0;
		long max = 0;
		for (int i = 0; i < n; i++)
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		System.out.println(result + " " + (index + 1));
		// System.out.println(CheckTriangle(p[0], p[1], p[2]));

	}
	public static boolean Collinear(point a, point b, point c)
	{
		if((a.y-b.y)*(a.x-c.x)==(a.y-c.y)*(a.x-b.x))
			return true;
		else
			return false;
	}
	public static double Lenght(point a, point b)
	{
		double result=Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		return result;
	}
	public static boolean Check(point a, point b, point c) {

		double A=Lenght(a,b);
		double B=Lenght(b,c);
		double C=Lenght(a,c);
		
		if(Double.compare(A+B, C)>0 && Double.compare(A+C, B)>0 && Double.compare(C+B, A)>0)
			return true;
		else return false;
		
	}

}

class point {
	int x;
	int y;
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
