package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;
import java.util.*;

public class HoiTruong_2187 {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        book[] a = new book[n];

        for (int i = 0; i < n; i++) {
            a[i] = new book();
            a[i].p = in.nextInt();
            a[i].k = in.nextInt();
        }
        Arrays.sort(a);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = a[i].k - a[i].p;
            for (int j = 0; j < i; j++) {
                if (a[j].k <= a[i].p) {
                    dp[i] = Math.max(dp[i], dp[j] + (a[i].k - a[i].p));
                }
            }
            res = Math.max(res,dp[i]);
        }
        out.println(res);
    }
}

class book implements Comparable<book>{
    int p;
    int k;

    public int compareTo(book b1) {
        return this.p - b1.p;
    }
}

