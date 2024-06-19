import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] arr = new int[n];
        int cnt = 0;

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=arr.length-1; i>=0; i--) {
            if (k >= arr[i]) {
                cnt += k / arr[i];
                k %= arr[i];
            }
        }
        bw.write(cnt+"");
        bw.flush();

    }

}