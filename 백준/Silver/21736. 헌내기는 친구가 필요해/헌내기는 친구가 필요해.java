import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if (row.charAt(j) == 'I') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
                if (map[nx][ny] == 'X' || visited[nx][ny]) continue;
                if(map[nx][ny] == 'P')
                    cnt++;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        if (cnt == 0) {
            bw.write("TT");
        } else {
            bw.write(cnt+ " ");
        }

        bw.flush();
    }
}
