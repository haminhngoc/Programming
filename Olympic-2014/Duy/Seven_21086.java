package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;

public class Seven_21086 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] s = in.next().toCharArray();
        int[] a = new int[1000001];
        int[] res = new int[1000001];
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] - '0' == 7) {
                int cnt = 1;
                int j = i + 1;
                while (j < s.length && s[j] - '0' == 7) {
                    cnt++;
                    j++;
                }
                max = Math.max(max, cnt);
                a[cnt]++;
                i = j - 1;
            }
        }
        int m = 0;
        int k = 0;
        for (int i = max; i >= 1; i--) {
            if (a[i] != 0) {
                res[i] += a[i];
                m += 2 * a[i];
                k += a[i];
            }
            res[i - 1] += m;
            m += k;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < max; i++) {
            if (res[i] != 0) {
                ans.append(i + " " + res[i] + "\n");
            }
        }
        ans.append(max + " " + res[max]);
        out.write(ans.toString());
    }
}
