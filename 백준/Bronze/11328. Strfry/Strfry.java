import java.io.*;

import static java.lang.Math.abs;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] inputs;
        int[] arr1, arr2;
        boolean flag;
        for (int i = 0; i < T; i++) {
            inputs = br.readLine().split(" ");
            arr1 = new int[26];
            arr2 = new int[26];
            flag = true;
            for (char ch : inputs[0].toCharArray()) {
                int idx = (int) (ch - 'a');
                arr1[idx]++;
            }

            for (char ch : inputs[1].toCharArray()) {
                int idx = (int) (ch - 'a');
                arr2[idx]++;
            }

            for (int j = 0; j < 26; j++) {
                if (arr1[j] != arr2[j]) {
                    bw.write("Impossible\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                bw.write("Possible\n");
            }
        }


        bw.flush();
    }
}