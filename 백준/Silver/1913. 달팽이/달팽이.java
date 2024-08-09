import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int goal = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int curX = 0;
        int curY = 0;
        int direction = 0;
        int cur = N * N;
        int goalX = 0;
        int goalY = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        arr[curX][curY] = cur--;
        while (cur != 0) {
            int nx = curX + dx[direction];
            int ny = curY + dy[direction];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) {
                direction = (direction + 1) % 4;
                continue;
            }

            if (arr[nx][ny] != 0) {
                direction = (direction + 1) % 4;
                continue;
            }

            arr[nx][ny] = cur--;
            curX = nx;
            curY = ny;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == goal){
                    goalX = i+1;
                    goalY = j+1;
                }
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.write(goalX + " " + goalY);
        bw.flush();
    }
}
