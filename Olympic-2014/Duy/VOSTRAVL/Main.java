import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        VOSTRAVL solver = new VOSTRAVL();
        solver.solve(1, in, out);
        out.close();
    }
}

class VOSTRAVL {
    static int[] label;
    StringBuilder res;
    static int[][] a;
    static long num = 0;
    static int s;
    boolean checkRoad[];

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        s = in.nextInt();
        int k = in.nextInt();

        if (k == 0) {
            out.println("TAK");
            out.println(1 + " " + s);
            return;
        }
        checkRoad = new boolean[n];
        a = new int[n][];
        label = new int[n];
        int[] x = new int[m];
        int[] y = new int[m];
        int[] cnt = new int[n];
        int[] curPos = new int[n];
        for (int i = 0; i < m; i++) {
            x[i] = (in.nextInt() - 1);
            y[i] = (in.nextInt() - 1);
            cnt[x[i]]++;
            cnt[y[i]]++;
        }
        for (int i = 0; i < n; i++) {
            a[i] = new int[cnt[i]];
        }
        for (int i = 0; i < m; i++) {
            a[x[i]][curPos[x[i]]] = y[i];
            curPos[x[i]]++;
            a[y[i]][curPos[y[i]]] = x[i];
            curPos[y[i]]++;
        }

        int id = 0;
        for (int j = 0; j < n; j++) {
            if (label[j] == 0) {
                id++;
                dfs(a, j, id);
            }
        }

        boolean check = true;
        int root = label[s - 1];
        for (int i = 0; i < k; i++) {
            int c = in.nextInt();
            if (label[c - 1] != root) {
                check = false;
                break;
            }
        }
        if (check) {
            num = 0;
            out.println("TAK");
            res = new StringBuilder();
            buildRoad(-1, s - 1);
            out.print(num);
            out.println(res);


        } else {
            out.println("NIE");
        }
    }

    private void buildRoad(int parent, int cur) {
        if (!checkRoad[cur]) {
            res.append(" " + (cur + 1));
            num++;
            if (cur != s - 1) {
                checkRoad[cur] = true;
            }
            for (int i = 0; i < a[cur].length; i++) {
                if (!checkRoad[a[cur][i]] && a[cur][i] != parent) {
                    buildRoad(cur, a[cur][i]);
                }
            }
            if (parent != -1) {
                res.append(" " + (parent + 1));
                num++;
            }
        }
    }

    private void dfs(int[][] a, int j, int id) {
        label[j] = id;
        int length = a[j].length;
        for (int i = 0; i < length; i++) {
            int tmp = a[j][i];
            if (label[tmp] == 0) {
                dfs(a, tmp, id);
            }
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
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
