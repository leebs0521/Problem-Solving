import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] student;
    static int[] state;
    static int NOT_VISITED = -1;
    static int VISITED = 1;
    static int CYCLE_IN = 2;
    static int NOT_CYCLE_IN = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            state = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(state, -1);
            for (int i = 1; i <= N; i++) {
                if (state[i] == NOT_VISITED) run(i);
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (state[i] == NOT_CYCLE_IN) ans++;
            }

            bw.write(ans + "\n");

        }
        bw.flush();
    }

    private static void run(int start) {
        int cur = start;

        while (true) {
            state[cur] = VISITED;
            cur = student[cur];

            // 이미 사이클이거나 이미 사이클이 아닌 경우 -> 사이클이 아님
            if (state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN) {
                cur = start;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = student[cur];
                }
                return;
            }

            // 사이클을 찾았는데 시작점이 아닌 경우
            if (state[cur] == VISITED && cur != start) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = student[cur];
                }
                cur = start;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = student[cur];
                }

                return;
            }
            
            // 사이클을 찾았는데 시작점인 경우
            if (state[cur] == VISITED && cur == start) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = student[cur];
                }
                return;
            }
        }
    }
}