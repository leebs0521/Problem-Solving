import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] dist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        dist = new int[N + 1];
        bfs(N);
        bw.write(dist[1] + "");
        bw.flush();
    }

    static void bfs(int n) {
        visited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == 1){
                return;
            }

            if(cur % 3 == 0 && !visited[cur / 3]){
                dist[cur / 3] = dist[cur] + 1;
                visited[cur / 3] = true;
                q.add(cur / 3);
            }

            if (cur % 2 == 0 && !visited[cur / 2]) {
                dist[cur / 2] = dist[cur] + 1;
                visited[cur / 2] = true;
                q.add(cur / 2);
            }
            if (!visited[cur - 1]) {
                dist[cur - 1] = dist[cur] + 1;
                visited[cur - 1] = true;
                q.add(cur - 1);
            }
        }
    }
}
