import java.io.*;
import java.util.Arrays;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(dist[i], 1000000000);
            dist[i][i] = 0;
        }
        for (int i=0; i<m ;i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (dist[a-1][b-1] > c) {
                dist[a-1][b-1] = c;
            }
        }

        for(int k=0; k<n; k++) {
            for (int a=0; a<n; a++) {
                for(int b=0; b<n; b++) {
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }

        for (int a=0; a<n; a++) {
            for (int b=0; b<n; b++) {
                if(dist[a][b] == 1000000000)
                    bw.write(0+" ");
                else
                    bw.write(dist[a][b] + " ");
            }
            bw.newLine();;
        }

        bw.flush();
    }
}