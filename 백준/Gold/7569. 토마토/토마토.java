import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);;
        int H = Integer.parseInt(inputs[2]);;

        Deque<Point> q = new LinkedList<>();
        int [][][] graph = new int[H][N][M];
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++){
                inputs = br.readLine().split(" ");
                for (int k=0; k<M; k++){
                    graph[i][j][k] = Integer.parseInt(inputs[k]);
                    if (graph[i][j][k] == 1) {
                        q.add(new Point(i, j, k));
                    }
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Point p = q.pollFirst();
            int x = p.x;
            int y = p.y;
            int z = p.z;

            for (int i=0; i<6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H) {
                    if (graph[nz][nx][ny] == 0) {
                        graph[nz][nx][ny] = graph[z][x][y] + 1;
                        q.add(new Point(nz, nx, ny));
                    }
                }
            }
        }

        boolean isPossible = true;
        int day = 0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (graph[i][j][k] == 0) {
                        isPossible = false;
                        break;
                    }
                    day = Math.max(day, graph[i][j][k]);
                }
            }
        }

        if (isPossible) {
            bw.write((day-1) + "");
        } else {
            bw.write(-1+"");
        }
        bw.flush();
    }
}

class Point{
    int z;
    int x;
    int y;


    public Point(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}