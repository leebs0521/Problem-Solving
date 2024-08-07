import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }

        Arrays.sort(arr);

        int removeN = (int)Math.round(N * 0.15);

        for (int i = 0; i < removeN; i++) {
            sum -= arr[i];
        }

        for (int i = N - removeN; i < N; i++) {
            sum -= arr[i];
        }

        int rating = (int) Math.round((float) sum / (N - 2 * removeN));
        System.out.println(rating);
    }

}