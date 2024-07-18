import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] board = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];

        int cnt = 0;
        int depth = 0;
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !isVisited[i][j]) {
                    cnt++;
                    depth = Math.max(BFS(i, j, board, isVisited), depth);
                }
            }
        }
        bw.write(cnt+"\n"+depth);
        bw.flush();
    }

    private static int BFS(int x, int y, int[][] board, boolean[][] isVisited) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        isVisited[x][y] = true;
        int d = 1;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx > board.length-1 || ny < 0 || ny > board[0].length-1) continue;
                if(board[nx][ny] == 0 || isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                d++;
            }
        }
        return d;
    }
}
