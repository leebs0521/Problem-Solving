import java.io.*;
import java.util.Collections;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[21];

        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            String[] inputs = br.readLine().split(" ");
            int begin = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            for (int j = 0; j < (end - begin + 1) / 2; j++) {
                int temp = arr[begin+j];
                arr[begin+j] = arr[end-j];
                arr[end-j] = temp;
            }
        }

        for (int i = 1; i <= 20; i++) {
            bw.write(arr[i]+ " ");
        }

        bw.flush();
    }
}