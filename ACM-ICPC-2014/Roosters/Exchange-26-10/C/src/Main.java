import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class Main {

	public static void main(String[] args) {
		int t = nextInt();
		while (t-- > 0) {
			solve();
		}

	}

	private static void solve() {
		
		int m =nextInt();
		int n = nextInt();
		int arr[][] = new int [m][n];
		for(int i =0; i<m; ++i){
			for(int j =0; j<n; ++j){
				arr[i][j] = nextInt();
			}
		}
		
		long result  =0;
		for(int i =0; i <n; ++i){
			int count  =0;
			for(int j =m-1; j>=0; --j){
				if(arr[j][i]==1){
					count++;
					result+=(m-j-count);
				}
			}
		}
		
		System.out.println(result);
		
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1000000];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static boolean hasNext() {

		if (lenbuf <= 0) {
			return false;
		}
		for (int i = ptrbuf; i < lenbuf; ++i) {
			if (!isSpace(bytes[i])) {
				return true;
			}
		}
		return false;
	}

	public static int readByte() {
		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return -1;
			}

		}

		return bytes[ptrbuf++];
	}

	public static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	public static char nextChar() {
		return (char) read();
	}

	public static String nextString() {
		StringBuilder str = new StringBuilder();

		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
	}

	public static int nextInt() {
		return Integer.parseInt(nextString());
	}

	public static long nextLong() {
		return Long.parseLong(nextString());
	}
}