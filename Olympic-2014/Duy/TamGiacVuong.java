package MyCode;

import MyCode.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        point[] p = new point[n];
        long[] xx = new long[(int) 1e5 + 1];
        long[] yy = new long[(int) 1e5 + 1];
        for (int i = 0; i < n; i++) {
            point tmp = new point();
            tmp.x = in.nextInt();
            tmp.y = in.nextInt();
            p[i] = tmp;
            xx[tmp.x]++;
            yy[tmp.y]++;
        }
        Arrays.sort(p, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (p[i].x == p[i + 1].x) {
                long z = xx[p[i].x] - 1;
                long z1 = 0;
                while (i < n - 1 && p[i].x == p[i + 1].x) {
                    res += (yy[p[i].y] - 1) * z + (yy[p[i].y] - 1) * z1;
                    z--;
                    z1++;
                    i++;
                }
                res += (yy[p[i].y] - 1) * z + (yy[p[i].y] - 1) * z1;
            }
        }
        out.println(res);

    }
}

class point {
    int x;
    int y;
}
