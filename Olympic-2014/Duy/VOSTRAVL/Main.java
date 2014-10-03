import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    static int[] label;
    StringBuilder res;
    static List<Integer>[] a;
    static long num = 0;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int k = in.nextInt();
        label = new int[n];
        a = new List[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x - 1].add(y - 1);
            a[y - 1].add(x - 1);
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
            res.append(s);
            num++;
            for (int i = 0; i < a[s - 1].size(); i++) {
                int temp = a[s - 1].get(i);
                if (label[temp] == root) {
                    res.append(" " + (temp + 1));
                    num++;
                    buildRoad(s - 1, temp, root);
                }
            }
            out.print(num + " ");
            out.println(res);


        } else {
            out.println("NIE");
        }
    }

    private void buildRoad(int p, int node, int root) {
        int length = a[node].size();
        if (length == 1) {
            res.append(" " + (p + 1));
            num++;
        } else {
            for (int i = 0; i < length; i++) {
                int temp = a[node].get(i);
                if (label[temp] == root && temp != p) {
                    res.append(" " + (temp + 1));
                    num++;
                    buildRoad(node, temp, root);
                }
            }
            res.append(" " + (p + 1));
            num++;
        }
        // return res.toString();
    }

    private void dfs(List<Integer>[] a, int j, int id) {
        label[j] = id;
        int length = a[j].size();
        for (int i = 0; i < length; i++) {
            int tmp = a[j].get(i);
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
