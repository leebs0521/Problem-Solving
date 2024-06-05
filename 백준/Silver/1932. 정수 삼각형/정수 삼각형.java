import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][];
        int[][] dp = new int[n][];

        for(int i=0; i<n; i++) {
            int[] arr = new int[i+1];
            dp[i] = arr;
        }
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[i+1];
            for(int j=0; j<input.length; j++)
                arr[j] = Integer.parseInt(input[j]);

            tri[i] = arr;
        }

        dp[0][0] = tri[0][0];

        for(int i=1; i<tri.length; i++) {
            for(int j=0; j<tri[i].length; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + tri[i][j];
                }
                else if(j == tri[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + tri[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
                }
            }
        }

        bw.write(Arrays.stream(dp[n-1]).max().getAsInt() +"");
        bw.flush();
    }
}