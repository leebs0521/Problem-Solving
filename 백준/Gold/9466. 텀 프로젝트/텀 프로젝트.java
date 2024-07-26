import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] student;
    static int[] state;
    static int NOT_VISITED = 0;
    static int CYCLE_IN = -1;

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

            for (int i = 1; i <= N; i++) {
                if (state[i] == NOT_VISITED) run(i);
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (state[i] != CYCLE_IN) ans++;
            }

            bw.write(ans + "\n");

        }
        bw.flush();
    }

    private static void run(int start) {
        int cur = start;

        while (true) {
            state[cur] = start;
            cur = student[cur];

            // 사이클을 찾은 경우
            if (state[cur] == start) {
                while(state[cur] != CYCLE_IN){
                    state[cur] = CYCLE_IN;
                    cur = student[cur];
                }
                return;
            }
            // 이전 사이클에서 방문한 학생인 경우
            else if(state[cur] != 0) return;
        }
    }
}