import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        int[][] graph;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        int[] dx = {0, 0, 1, -1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, -1, 1, -1, 1, -1};

        while (true) {

            years++;
            int[][] new_graph = new int[N][M];
            Queue<Point> q = new LinkedList<>();

            // 빙하 녹이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(graph[i][j] != 0){
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1) continue;
                            if(graph[nx][ny] == 0 ) cnt++;
                        }
                        new_graph[i][j] = Math.max(0, graph[i][j] - cnt);
                    } else {
                        new_graph[i][j] = 0;
                    }
                }
            }
            // 빙하 나눠졌는지 체크 하기
            int cnt = 0;
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(new_graph[i][j] == 0 || visited[i][j]) continue;
                    cnt++;
                    visited[i][j] = true;
                    q.add(new Point(i, j));

                    while (!q.isEmpty()) {
                        Point cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1) continue;
                            if(visited[nx][ny] || new_graph[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
            if(cnt >= 2){
                bw.write(years+"\n");
                break;
            } else if(cnt == 0){
                bw.write("0\n");
                break;
            }
            graph = new_graph;
        }
        bw.flush();
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
