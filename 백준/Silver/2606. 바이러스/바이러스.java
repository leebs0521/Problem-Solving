import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            graph[start].add(new Edge(end));
            graph[end].add(new Edge(start));
        }

        boolean[] isVisited = new boolean[n + 1];
        isVisited[1] = true;
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);

        while (!dq.isEmpty()) {

            int cur = dq.pollFirst();

            for (Edge next : graph[cur]) {
                if (!isVisited[next.to]) {
                    dq.add(next.to);
                    isVisited[next.to] = true;
                }
            }
        }

        int cnt = 0;
        for (int i=2; i<=n; i++) {
            if(isVisited[i]) {
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }
}

class Edge {
    int to;

    public Edge(int to) {
        this.to = to;
    }
}
