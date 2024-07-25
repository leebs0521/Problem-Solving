import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] cards;
    static boolean[] used;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        choose(0, 0, 0);
        bw.write(ans + "");
        bw.flush();
    }

    private static void choose(int depth, int start, int sum) {
        if (depth == 3) {
            if (sum <= M) {
                ans = Math.max(ans, sum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            choose(depth + 1, i + 1, sum + cards[i]);
        }
    }
}
