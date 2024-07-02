import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(inputs[i-1]);
        }

        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            bw.write((sum[end] - sum[start - 1]) + "\n");
        }

        bw.flush();
    }
}