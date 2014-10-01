package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class SoPhongPhu_3620 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int from = in.nextInt();
        int to = in.nextInt();
        int[] mark = new int[100001];
        Arrays.fill(mark, 1);
        for (int i = 2; i <= to / 2; i++) {
            int tmp = i+i;
            while (tmp <= to) {
                mark[tmp] += i;
                tmp += i;
            }
        }
        int cnt = 0;
        for (int cur = from; cur <= to; cur++) {
            if (mark[cur] > cur) {
                cnt++;
            }
        }
        out.println(cnt);
    }
}
