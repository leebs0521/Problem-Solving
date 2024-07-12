import java.io.*;

import static java.lang.Math.abs;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];

        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(inputs[i])]++;
        }

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int idx = X - Integer.parseInt(inputs[i]);

            if (idx <= 0) {
                continue;
            }

            if (arr[idx] == 1) {
                cnt++;
            }

        }
        bw.write(cnt/2 + "");
        bw.flush();
    }
}