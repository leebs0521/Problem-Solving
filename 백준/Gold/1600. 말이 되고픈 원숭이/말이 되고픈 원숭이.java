import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[][] graph;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dxHorse = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dyHorse = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dxMonkey = {0, 0, 1, -1};
        int[] dyMonkey = {1, -1, 0, 0};

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Monkey cur = q.poll();
            if (cur.x == H - 1 && cur.y == W - 1) {
                bw.write(cur.dist+"");
                bw.flush();
                return;
            }
            // 아직 K 만큼 말 이동 x 상태
            if(cur.k < K){
                // case 1 말 처럼 이동
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dxHorse[i];
                    int ny = cur.y + dyHorse[i];
                    if(nx < 0 || nx > H-1 || ny < 0 || ny > W-1) continue;
                    if(graph[nx][ny] == 1 || visited[nx][ny][cur.k+1]) continue;
                    visited[nx][ny][cur.k+1] = true;
                    q.add(new Monkey(nx, ny, cur.k + 1, cur.dist + 1));
                }
            }
            // case 2 그냥 몽키처럼 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxMonkey[i];
                int ny = cur.y + dyMonkey[i];

                if(nx < 0 || nx > H-1 || ny < 0 || ny > W-1) continue;
                if(graph[nx][ny] == 1 || visited[nx][ny][cur.k]) continue;
                visited[nx][ny][cur.k] = true;
                q.add(new Monkey(nx, ny, cur.k, cur.dist + 1));
            }
        }
        bw.write("-1");
        bw.flush();
    }
}
class Monkey{
    int x;
    int y;
    int k;
    int dist;

    public Monkey(int x, int y, int k, int dist) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.dist = dist;
    }
}