import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] eggs;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2]; // 내구도 무게

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        breakEgg(0, 0);
        bw.write(ans+"");
        bw.flush();

    }
    static void breakEgg(int depth, int cnt) {
        if (depth == N) {
            ans = Math.max(ans, cnt);
            return;
        }

        if (eggs[depth][0] <= 0 || cnt == N - 1) {
            breakEgg(depth + 1, cnt);
            return;
        }

        int nCnt = cnt;

        for (int i = 0; i < N; i++) {
            if(i == depth) continue;
            if(eggs[i][0] <= 0) continue;

            eggs[depth][0] -= eggs[i][1];
            eggs[i][0] -= eggs[depth][1];

            if (eggs[depth][0] <= 0) cnt++;
            if (eggs[i][0] <= 0) cnt++;

            breakEgg(depth+1, cnt);

            eggs[depth][0] += eggs[i][1];
            eggs[i][0] += eggs[depth][1];
            cnt = nCnt;
        }
    }
}