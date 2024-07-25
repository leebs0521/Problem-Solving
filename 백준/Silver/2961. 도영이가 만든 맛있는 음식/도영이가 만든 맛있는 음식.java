import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] taste;
    static boolean[] used;
    static long ans = (int) 1e09;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        back(0);
        System.out.println(ans);
    }

    static void back(int depth) {
        if (depth == N) {
            int cnt = 0;
            long tasteSum1 = 1;
            long tasteSum2 = 0;
            for (int i = 0; i < N; i++) {
                if (used[i]) {
                    tasteSum1 *= taste[i][0];
                    tasteSum2 += taste[i][1];
                    cnt++;
                }
            }
            if (cnt == 0) return;
            long abs = Math.abs(tasteSum1 - tasteSum2);
            ans = Math.min(abs, ans);
            return;
        }

        used[depth] = true;
        back(depth + 1);
        used[depth] = false;
        back(depth + 1);
    }
}
