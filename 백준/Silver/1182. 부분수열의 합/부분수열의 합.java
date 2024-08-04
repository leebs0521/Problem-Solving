import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] arr;
    static boolean[] used;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        back(0, 0);
        if (S == 0) cnt--;
        bw.write(cnt+"");
        bw.flush();
    }
    static void back(int depth, int cur) {
        if (depth == N) {
            if(cur == S){
                cnt++;
            }
            return;
        }

        back(depth + 1, cur + arr[depth]);
        back(depth + 1, cur);
    }
}
