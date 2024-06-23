import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int INF = 1000000000;
    static int N, M, X; // 학생 수, 노드 수, 특정 마을 X

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        X = Integer.parseInt(inputs[2]);

        int[][] graph = new int[N+1][N+1];
        for (int i=0; i<N+1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i=0; i<M; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph[start][end] = cost;
        }

        int[] ans = dijkstra(X, graph);
        ans[0] = 0;
        for(int i=1;i<N+1; i++) {
            if (i != X) {
                int[] iToX = dijkstra(i, graph);
                ans[i] += iToX[X];
            }
        }

        bw.write(Arrays.stream(ans).max().getAsInt()+"");
        bw.flush();
    }

    // start 에서 다른 마을로 가는 최단 비용을 계산하는 함수
    static int[] dijkstra(int start, int[][] graph) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Graph> pq = new PriorityQueue<>(1, new GraphComparator());
        pq.add(new Graph(start, 0));

        while (!pq.isEmpty()) {
            Graph cur = pq.poll();
            if (dist[cur.node] >= cur.cost) {
                for (int i=1; i<N+1; i++) {
                    int new_cost = cur.cost + graph[cur.node][i];
                    if (new_cost < dist[i]) {
                        dist[i] = new_cost;
                        pq.add(new Graph(i, new_cost));
                    }
                }
            }
        }
        return dist;
    }

}

class Graph{
    int node;
    int cost;
    public Graph(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class GraphComparator implements Comparator<Graph>{

    @Override
    public int compare(Graph o1, Graph o2) {
        return Integer.compare(o1.cost, o2.cost);
    }
}
