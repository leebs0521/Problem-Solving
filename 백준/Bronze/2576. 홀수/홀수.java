import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int min = 101;
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n % 2 == 1) {
                sum += n;

                if (n < min) {
                    min = n;
                }
            }
        }
        if (sum == 0) {
            bw.write("-1");
        }
        else {
            bw.write(sum + "\n");
            bw.write(min + "");
        }
        bw.flush();
    }
}
