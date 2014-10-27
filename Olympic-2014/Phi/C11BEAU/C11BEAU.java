import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in,out);
		out.close();
	}

}

class Task{
	
	public void solve(InputReader in, PrintWriter out){
		int nTest = in.nextInt();
		while(nTest-- > 0){
			long countA = in.nextLong();
			long countB = in.nextLong();
			long maxA = in.nextLong();
			long maxB = in.nextLong();
			long res = 0;
			if(maxA == 0){
				res = Math.min(countB, maxB);
				out.println(res);
				continue;
			}
			if(maxB == 0){
				res = Math.min(countA, maxA);
				out.println(res);
				continue;
			}
			long nA = (countA + maxA - 1) / maxA;
			long nB = (countB + maxB - 1) / maxB;
			if(nA < nB){
				res = Math.min(nA*maxA, countA) + Math.min((nA+1)*maxB, countB);
				if(countA < nB){
					res = Math.max(res, countA + Math.min((countA+1)*maxB, countB));
				}
				if(nB < countA){
					res = Math.max(res, countB + Math.min((nB+1)*maxA, countA));
				}
				if(nB == countA){
					res = Math.max(res, countA + Math.min(nB*maxB,countB));
				}
				
			}
			if(nB < nA){
				res = Math.min(nB*maxB, countB) + Math.min((nB+1)*maxA, countA);
				if(countB < nA){
					res = Math.max(res,countB + Math.min((countB+1)*maxA, countA));
				}
				if(nA < countB){
					res = Math.max(res, countA + Math.min((nA+1)*maxB, countB));
				}
				if(nA == countB){
					res = Math.max(res, countB + Math.min(nA*maxA,countA));
				}
				
			}
			if(nA == nB){
				res = Math.max(res, countA + countB);
			}
			out.println(res);
		}		
	}
}

class InputReader{
	BufferedReader reader;
	StringTokenizer tokenizer;
	
	InputReader(InputStream stream){
		reader = new BufferedReader(new InputStreamReader(stream),32768);
		tokenizer = null;
	}
	
	public String next(){
		while(tokenizer == null || !tokenizer.hasMoreTokens()){
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tokenizer.nextToken();
	}
	
	public int nextInt(){
		return Integer.parseInt(next());
	}
	
	public long nextLong(){
		return Long.parseLong(next());
	}
}
