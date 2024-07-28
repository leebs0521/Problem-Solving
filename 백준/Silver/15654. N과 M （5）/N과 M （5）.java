import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] used;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0);

        bw.flush();
    }

    private static void perm(int depth) throws IOException {
        if(depth == M){
            for(int i=0;i<M; i++) {
                bw.write(ans[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            ans[depth] = arr[i];
            perm(depth + 1);
            used[i] = false;
        }
    }
}
