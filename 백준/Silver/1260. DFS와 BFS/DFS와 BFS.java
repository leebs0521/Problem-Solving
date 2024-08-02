import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static boolean[][] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        DFS(V);
        bw.newLine();
        Arrays.fill(visited, false);
        BFS(V);
        bw.flush();
    }
    static void DFS(int node) throws IOException {
        bw.write(node + " ");
        visited[node] = true;
        for (int i = 1; i < N + 1; i++) {
            if(!graph[node][i] || visited[i]) continue;
            visited[i] = true;
            DFS(i);
        }
    }

    static void BFS(int node) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");
            for (int i = 1; i < N + 1; i++) {
                if(!graph[cur][i] || visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}
