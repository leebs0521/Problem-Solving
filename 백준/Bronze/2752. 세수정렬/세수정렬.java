import java.io.*;
import java.util.Arrays;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < 3; i++) {
            bw.write(arr[i] + " ");
        }
        
        bw.flush();
    }
}
