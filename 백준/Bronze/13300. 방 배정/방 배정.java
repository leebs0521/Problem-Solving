import java.io.*;

import static java.lang.Math.abs;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[][] arr = new int[2][6];
        int needRooms = 0;

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int gender = Integer.parseInt(inputs[0]);
            int grade = Integer.parseInt(inputs[1]);

            arr[gender][grade-1]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] % K == 0) {
                    needRooms += arr[i][j] / K;
                } else {
                    needRooms += arr[i][j] / K + 1;
                }
            }
        }

        bw.write(needRooms+"");

        bw.flush();
    }
}