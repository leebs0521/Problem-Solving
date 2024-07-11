import java.io.*;
import java.util.Arrays;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs;


        for (int i = 0; i < 3; i++) {
            inputs = br.readLine().split(" ");
            int oneCnt = 0;
            int zeroCnt = 0;

            for (int j = 0; j < 4; j++) {
                if (inputs[j].charAt(0) == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }

            if (zeroCnt == 4) {
                bw.write("D\n");
            }

            if (zeroCnt == 3) {
                bw.write("C\n");
            }

            if (zeroCnt == 2) {
                bw.write("B\n");
            }

            if (zeroCnt == 1) {
                bw.write("A\n");
            }

            if (oneCnt == 4) {
                bw.write("E\n");
            }
        }

        bw.flush();
    }
}
