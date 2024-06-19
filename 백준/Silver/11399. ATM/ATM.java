import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int ans = 0;
        int waiting_time = 0;
        String[] inputs = br.readLine().split(" ");

        for (int i=0; i<n; i++) {
            times[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(times);

        for (int time : times) {
            waiting_time += time;
            ans += waiting_time;
        }

        bw.write(ans+"");
        bw.flush();
    }

}