import java.io.*;
import java.util.*;

public class Main {
    static int cnt, h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] inputs = br.readLine().split(" ");
            w = Integer.parseInt(inputs[0]);
            h = Integer.parseInt(inputs[1]);

            if (w == 0 && h == 0) {
                break;
            }

            int[][] graph = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            cnt = 0;

            for (int x=0; x<h; x++) {
                inputs = br.readLine().split(" ");
                for (int y=0; y<w; y++) {
                    graph[x][y] = Integer.parseInt(inputs[y]);
                }
            }

            for (int x=0; x<h; x++) {
                for (int y=0; y<w; y++) {
                    if (graph[x][y] == 1 && !visited[x][y]) {
                        cnt++;
                        visited[x][y] = true;
                        BFS(new Position(x,y), graph, visited);
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
    }
    static void BFS(Position start, int[][] graph, boolean[][] visited) {
        int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = {1, -1, 0, 0, -1 ,1, 1 ,-1};
        Deque<Position> q = new LinkedList<>();

        int x = start.x;
        int y = start.y;

        q.add(start);

        while (!q.isEmpty()) {
            Position p = q.pollFirst();

            for (int i=0; i<8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        q.add(new Position(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}