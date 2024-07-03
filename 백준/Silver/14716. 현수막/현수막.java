import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int H;
    static int W;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        H = Integer.parseInt(inputs[0]);
        W = Integer.parseInt(inputs[1]);

        board = new int[H][W];

        int cnt = 0;
        for (int i = 0; i < H; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    BFS(i, j);
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }

    public static void BFS(int a, int b) {
        Deque<int[]> dq = new LinkedList<>();
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        board[a][b] = 0;
        dq.add(new int[]{a, b});

        while (!dq.isEmpty()) {
            int[] pos = dq.pollFirst();
            for (int i = 0; i < 8; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (0 <= nx && nx < H && 0 <= ny && ny < W) {
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        dq.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}