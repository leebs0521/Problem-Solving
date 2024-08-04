import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] used;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N];
        ans = new int[M];

        perm(0);
        bw.write(sb.toString());
        bw.flush();
    }

    static void perm(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            ans[depth] = i+1;
            perm(depth+1);
            used[i] = false;
        }
    }
}