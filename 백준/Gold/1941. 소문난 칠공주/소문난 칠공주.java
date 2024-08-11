import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] seats;
    static int cnt;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seats = new char[5][5];
        ans = new int[7];

        for (int i = 0; i < 5; i++) {
            seats[i] = br.readLine().toCharArray();
        }
        comb(0, 0);
        bw.write(cnt+"");
        bw.flush();
    }

    static void comb(int depth, int cur) {
        if (depth == 7) {
            if (check())
                cnt++;
            return;
        }

        for (int i = cur; i < 25; i++) {
            ans[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    private static boolean check() {
        int sCnt = 0;
        boolean[][] board = new boolean[5][5];
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        int i;
        for (i = 0; i < 7; i++) {
            int row = ans[i] / 5;
            int col = ans[i] % 5;
            if(seats[row][col] == 'S')
                sCnt++;
            board[row][col] = true;
        }
        int adj = 1;
        i--;
        q.add(new int[]{ans[i] / 5, ans[i] % 5});
        visited[ans[i] / 5][ans[i] % 5] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if(nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                if(!board[nx][ny] || visited[nx][ny]) continue;
                adj++;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        if (sCnt >= 4 && adj == 7) {
            return true;
        } else {
            return false;
        }
    }

}