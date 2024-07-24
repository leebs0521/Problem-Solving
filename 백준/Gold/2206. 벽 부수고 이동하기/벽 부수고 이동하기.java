import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][][] visited;
    static char[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][2];
        maze = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 1, false));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                bw.write(cur.cnt +"");
                bw.flush();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx > N-1 || ny < 0 || ny > M - 1) continue;

                // 벽이 아니면
                if (maze[nx][ny] == '0') {
                    if (!cur.isDestroyed && !visited[nx][ny][0]) { // 벽을 부순 적이 없는 경우
                        q.add(new Pos(nx, ny, cur.cnt + 1, false));
                        visited[nx][ny][0] =  true;
                    } else if (cur.isDestroyed && !visited[nx][ny][1]) { // 벽을 부순 경우
                        q.add(new Pos(nx, ny, cur.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                   // 벽이면
                    if (!cur.isDestroyed) {
                        q.add(new Pos(nx, ny, cur.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }

            }
        }

        bw.write("-1");
        bw.flush();
    }
}

class Pos{
    int x;
    int y;
    int cnt;
    boolean isDestroyed;

    public Pos(int x, int y, int cnt, boolean isDestroyed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.isDestroyed = isDestroyed;
    }
}
