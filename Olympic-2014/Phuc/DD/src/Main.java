import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * Built using CHelper plug-in Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	String[] res = new String[]{"1"
			,"2"
			,"3"
			,"5"
			,"8"
			,"13"
			,"21"
			,"34"
			,"55"
			,"89"
			,"144"
			,"233"
			,"377"
			,"610"
			,"987"
			,"1597"
			,"2584"
			,"4181"
			,"6765"
			,"10946"
			,"17711"
			,"28657"
			,"46368"
			,"75025"
			,"121393"
			,"196418"
			,"317811"
			,"514229"
			,"832040"
			,"1346269"
			,"2178309"
			,"3524578"
			,"5702887"
			,"9227465"
			,"14930352"
			,"24157817"
			,"39088169"
			,"63245986"
			,"102334155"
			,"165580141"
			,"267914296"
			,"433494437"
			,"701408733"
			,"1134903170"
			,"1836311903"
			,"2971215073"
			,"4807526976"
			,"7778742049"
			,"12586269025"
			,"20365011074"
			,"32951280099"
			,"53316291173"
			,"86267571272"
			,"139583862445"
			,"225851433717"
			,"365435296162"
			,"591286729879"
			,"956722026041"
			,"1548008755920"
			,"2504730781961"
			,"4052739537881"
			,"6557470319842"
			,"10610209857723"
			,"17167680177565"
			,"27777890035288"
			,"44945570212853"
			,"72723460248141"
			,"117669030460994"
			,"190392490709135"
			,"308061521170129"
			,"498454011879264"
			,"806515533049393"
			,"1304969544928657"
			,"2111485077978050"
			,"3416454622906707"
			,"5527939700884757"
			,"8944394323791464"
			,"14472334024676221"
			,"23416728348467685"
			,"37889062373143906"
			,"61305790721611591"
			,"99194853094755497"
			,"160500643816367088"
			,"259695496911122585"
			,"420196140727489673"
			,"679891637638612258"
			,"1100087778366101931"
			,"1779979416004714189"
			,"2880067194370816120"
			,"4660046610375530309"};
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int t = in.nextInt();
		int n;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; ++i){
			n = in.nextInt();
			sb.append(res[n-1] + "\n");
		}
		out.print(sb);
		/*
		int k;
		for (int n = 1; n <= 90; ++n) {

			BigInteger ikg = new BigInteger("1");
			BigInteger kg = new BigInteger("1");
			BigInteger ig = new BigInteger("1");
			BigInteger res = new BigInteger("0");
			BigInteger tmp = new BigInteger("0");
			for (int i = 0; i <= n / 2; ++i) {
				k = n - i * 2;
				ikg = new BigInteger("1");
				kg = new BigInteger("1");
				ig = new BigInteger("1");
				for (int j = 2; j <= k + i; ++j) {
					if (j <= i) {
						ig = ig.multiply(new BigInteger(Integer.toString(j)));
					}
					if (j <= k + i) {
						ikg = ikg.multiply(new BigInteger(Integer.toString(j)));
					}
					if (j <= k) {
						kg = kg.multiply(new BigInteger(Integer.toString(j)));
					}
				}
				tmp = ikg.divide(ig.multiply(kg));
				res = res.add(tmp);
			}
			out.println(",\"" + res + "\"");
		}*/
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