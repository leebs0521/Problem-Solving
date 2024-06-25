import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i=0; i<N; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(inputs.charAt(j));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    ans.add(BFS(i, j));
                }
            }
        }
        Collections.sort(ans);
        bw.write(ans.size()+"\n");
        for (Integer an : ans) {
            bw.write(an + "\n");
        }
        bw.flush();
    }

    private static int BFS(int row, int col) {
        Deque<int[]> dq = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        graph[row][col] = 0;
        int cnt = 1;
        dq.add(new int[]{row, col});

        while (!dq.isEmpty()) {
            int[] pos = dq.pollFirst();

            for (int i=0; i<4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;
                        cnt++;
                        dq.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return cnt;
    }
}