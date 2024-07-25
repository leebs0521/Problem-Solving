import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] s;
    static boolean[] used;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        s = new int[N][N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(0, 0);

        bw.write(ans+"");
        bw.flush();
    }

    private static void choose(int depth, int start) {
        if (depth == N / 2) {
            int temp = cal();
            ans = Math.min(temp, ans);
            return;
        }

        for (int i = start; i < N; i++) {
            used[i] = true;
            choose(depth + 1, i + 1);
            used[i] = false;
        }
    }

    private static int cal() {
        int teamFalse = 0;
        int teamTrue = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (used[i] && used[j]) {
                    teamTrue += s[i][j] + s[j][i];
                }

                if (!used[i] && !used[j]) {
                    teamFalse += s[i][j] + s[j][i];
                }

            }
        }
        return Math.abs(teamTrue - teamFalse);
    }
}
