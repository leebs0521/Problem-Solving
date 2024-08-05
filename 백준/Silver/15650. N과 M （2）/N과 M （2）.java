import java.io.*;
import java.util.*;

public class Main {


    static int N, M;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N];

        comb(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }
    static void comb(int depth, int cur) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if(used[i]) sb.append((i+1)+" ");
            }
            sb.append("\n");
            return;
        }
        if (cur == N) {
            return;
        }

        used[cur] = true;
        comb(depth + 1, cur + 1);
        used[cur] = false;
        comb(depth, cur + 1);
    }
}

