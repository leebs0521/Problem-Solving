import java.io.*;
import java.util.*;

public class Main {

    static int[] arr, ans;
    static int len;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());

            arr = new int[len];
            ans = new int[6];

            if (len == 0) {
                break;
            }

            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            comb(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void comb(int depth, int prev) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev; i < len; i++) {
            ans[depth] = arr[i];
            comb(depth + 1, i + 1);
        }
    }
}