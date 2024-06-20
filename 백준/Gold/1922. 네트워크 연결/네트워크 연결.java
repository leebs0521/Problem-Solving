import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int totalCost = 0;
        int[] parents = new int[v+1];
        for (int i=1; i<=v; i++)
            parents[i] = i;

        int[][] edges = new int[e][3]; // start, end, cost

        for (int i=0; i<e; i++) {
            String[] inputs = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(inputs[0]);
            edges[i][1] = Integer.parseInt(inputs[1]);
            edges[i][2] = Integer.parseInt(inputs[2]);
        }

        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            if (findParent(parents, start) != findParent(parents, end)) {
                unionParent(parents, start, end);
                totalCost += cost;
            }
        }

        bw.write(totalCost+"");
        bw.flush();

    }

    private static int findParent(int[] parents, int x) {
        if(parents[x] != x) {
            return findParent(parents, parents[x]);
        }
        return x;
    }

    private static void unionParent(int[] parents, int x, int y) {
        x = findParent(parents, x);
        y = findParent(parents, y);

        if (x > y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
}