import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        int[][] dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    dist[i][j] = 0;
                }
                if (graph[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
                if (graph[nx][ny] == 0 || dist[nx][ny] != -1) continue;
                dist[nx][ny] = cur[2] + 1;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }
}