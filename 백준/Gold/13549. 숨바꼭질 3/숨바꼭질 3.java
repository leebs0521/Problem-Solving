import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, K;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dist = new int[2000002];

        Arrays.fill(dist, -1);

        Deque<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while(!q.isEmpty()){
            int curPos = q.poll();
            int curDist = dist[curPos];
            int[] dx = {-1, 1};

            int doublePos = 2 * curPos;

            if (doublePos < 2000002 && dist[doublePos] == -1) {
                dist[doublePos] = curDist;
                q.addFirst(doublePos);
            }

            for (int i = 0; i < 2; i++) {
                int nx = curPos + dx[i];

                if(nx < 0 || nx > 2000001) continue;
                if(dist[nx] != -1) continue;

                dist[nx] = curDist + 1;
                q.add(nx);
            }
        }

        bw.write(dist[K]+"\n");
        bw.flush();
    }
}