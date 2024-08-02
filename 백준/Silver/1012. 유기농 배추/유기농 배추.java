import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[M][N];
            visited = new boolean[M][N];
            int cnt = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start][end] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j] || graph[i][j] == 0) continue;
                    cnt++;
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
    }
    static void dfs(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) continue;
            if(graph[nx][ny] == 0 || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
