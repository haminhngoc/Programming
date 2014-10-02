package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;

public class TimSoNguyenTo_1783 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int from = in.nextInt();
        int to = in.nextInt();
        from = Math.max(2, from);
        for (int cur = from; cur <= to; cur++) {
            if (isPrime(cur)) {
                out.println(cur);
            }
        }
    }

    static boolean isPrime(int cur) {
        for (int i = 2; i <= Math.sqrt(cur); i++) {
            if (cur % i == 0) {
                return false;
            }
        }
        return true;
    }
}
