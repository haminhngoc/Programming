import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;
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
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSPOJ {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer,Edge>[] graph = new HashMap[n+1];
        for(int i = 0; i <= n; ++i){
            graph[i] = new HashMap<Integer, Edge>();
        }
        List<Edge> edges = new ArrayList<Edge>();
        int type,x,y;
        Queue<Request> requests = new LinkedList<Request>();
        Request request;
        Edge edge;
        for(int i = 0; i < m; ++i){
            type = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            if(type == 1){
                if(!graph[x].containsKey(y)){
                    edge = new Edge();
                    edge.tin = i;
                    edge.tout = 0;
                    edge.x = x;
                    edge.y = y;
                    graph[x].put(y,edge);
                    graph[y].put(x,edge);
                } else {
                    edge = graph[x].get(y);
                    edge.tout++;
                    graph[x].put(y,edge);
                    graph[y].put(x,edge);
                }

            }
            if(type == 2){
                if(graph[x].containsKey(y)){
                    edge = graph[x].get(y);
                    if(edge.tout == 0){
                        edge.tout = i;
                        edges.add(edge);
                        graph[x].remove(y);
                        graph[y].remove(x);
                    } else {
                        edge.tout--;
                        graph[x].put(y,edge);
                        graph[y].put(x,edge);
                    }
                }
            }
            if(type == 3){
                request = new Request();
                request.x = x;
                request.y = y;
                request.time = i;
                requests.add(request);
            }
        }
        Iterator it;
        for(int i = 0; i <= n; ++i){
            it = graph[i].entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer,Edge> pairs = (Map.Entry<Integer,Edge>)it.next();
                edge = pairs.getValue();
                edge.tout = m;
                edges.add(edge);
                graph[pairs.getKey()].remove(i);
                it.remove();
            }
        }

        UnionSets set;
        StringBuilder sb = new StringBuilder();
        while(requests.size() != 0){
            request = requests.poll();
            set = new UnionSets(n+1);
            for(Edge e : edges){
                if(e.tin < request.time && request.time < e.tout && !set.isSameSet(e.x,e.y)){
                    set.unionSet(e.x,e.y);
                }
            }
            if(set.isSameSet(request.x,request.y)){
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        out.println(sb);
    }
}

class Request{
    int x;
    int y;
    int time;
}

class Edge{
    int x;
    int y;
    int tin;
    int tout;
}

class UnionSets {
    int[] pset;

    DisjointSets(int n){
        pset = new int[n];
        for (int i = 0; i < n; i++) {
            pset[i] = i;
        }
    }

    int findSet(int i){
        if(pset[i] == i) return i;
        return pset[i] = findSet(pset[i]);
    }

    void unionSet(int i, int j){
        pset[findSet(i)] = findSet(j);
    }

    boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j);
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

