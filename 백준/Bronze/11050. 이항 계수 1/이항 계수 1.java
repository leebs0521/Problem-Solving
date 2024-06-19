import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[][] cache = new int[11][11];

        for (int i=0; i<11; i++){
            cache[i][0] = 1;
            cache[i][i] = 1;
        }

        for (int i=1; i<11; i++) {
            for (int j=1; j<11; j++) {
                cache[i][j] = cache[i-1][j] + cache[i-1][j-1];
            }
        }

        bw.write(cache[n][k]+"");
        bw.flush();
    }

}