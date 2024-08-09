import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr, ans;
    static Set<String> s = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0, 0);
        for (String string : s) {
           bw.write(string);
        }
        bw.flush();
    }

    static void perm(int depth, int cur) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            s.add(sb.toString());
            return;
        }

        for (int i = cur; i < N; i++) {
            ans[depth] = arr[i];
            perm(depth+1, i+1);
        }
    }
}
