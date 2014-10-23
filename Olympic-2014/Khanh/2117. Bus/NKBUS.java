import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class NKBUS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxStaff = 200000;
		InputReader2117 in = new InputReader2117(System.in);
		int nStation = in.nextInt();
		int nSeat = in.nextInt();
				
		int[] arrTime = new int[maxStaff + 1];
		for (int i = 0; i < maxStaff+1; ++i)
			arrTime[i] = 0;
		
		int cTime = 0;
		for (int iS = 0; iS < nStation; ++iS) {
			int t = in.nextInt();
			int nStaff = in.nextInt();
			for (int iSt = 0; iSt < nStaff; ++iSt) {
				int x = in.nextInt();
				if (x > cTime)
					arrTime[x - cTime]++;
				else
					arrTime[0]++;
			}
			cTime += t;
		}

		int timePlus = 0;
		int nStaff = 0;
		while (timePlus <= maxStaff) {
			nStaff += arrTime[timePlus];
			if (nStaff < nSeat)
				timePlus++;
			else
				{
				System.out.println("" + (cTime + timePlus));
				return;
				}
		}
	}

}

class InputReader2117 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader2117(InputStream stream) {
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