import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=1;i<N+1;i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        System.out.println();
        visited = new boolean[1001]; //방문상태 초기화
        bfs(V);
    }

    public static void dfs(int x) { //stack
        visited[x] = true;
        System.out.print(x+" ");
        for(int num : graph.get(x)) {
            if(!visited[num]) {
                dfs(num);
            }
        }
    }

    public static void bfs(int x) { //queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int value = queue.poll();
            System.out.print(value+ " ");

            for(int num : graph.get(value)) {
                if(!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }

    }
}
