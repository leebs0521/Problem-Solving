import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};

    static int[] dy = {1, -1, 0, 0, -1 ,1, 1 ,-1};

    static int W, H, cnt;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            cnt = 0;
            graph = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(graph[i][j] == 0 || visited[i][j]) continue;
                    cnt++;
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }

            bw.write(cnt+"\n");
        }
        bw.flush();
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx > H - 1 || ny < 0 || ny > W - 1) continue;
            if(graph[nx][ny] == 0 || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
        }

    }
}
