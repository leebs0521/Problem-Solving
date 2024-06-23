import java.io.*;
import java.util.*;

public class Main {

    static int INF = 1000000000;
    static int N, M, X; // 마을 수, 간선 수, 특정 마을 X

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        X = Integer.parseInt(inputs[2]);

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph[start].add(new Edge(end, cost));
        }

        int[] distFromX = dijkstra(X, graph);
        int maxDistance = 0;

        for (int i = 1; i <= N; i++) {
            if (i != X) {
                int[] distToX = dijkstra(i, graph);
                maxDistance = Math.max(maxDistance, distFromX[i] + distToX[X]);
            }
        }

        bw.write(maxDistance + "");
        bw.flush();
    }

    // 다익스트라 알고리즘으로 start에서 모든 노드까지의 최단 거리를 반환
    static int[] dijkstra(int start, List<Edge>[] graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.cost) continue;

            for (Edge next : graph[cur.to]) {
                int new_cost = cur.cost + next.cost;
                if (new_cost < dist[next.to]) {
                    dist[next.to] = new_cost;
                    pq.add(new Edge(next.to, new_cost));
                }
            }
        }

        return dist;
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
