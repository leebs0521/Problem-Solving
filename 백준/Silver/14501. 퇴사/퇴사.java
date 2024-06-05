import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] pay = new int[n];
        int[] dp = new int[n+1];

        for (int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            times[i] = Integer.parseInt(s[0]);
            pay[i] = Integer.parseInt(s[1]);
        }

        for(int i=0;i<n; i++){
            for(int j=i+times[i]; j<n+1; j++){
                if (dp[j] < dp[i] + pay[i])
                    dp[j] = dp[i] + pay[i];
            }
        }

        bw.write(dp[dp.length-1]+"");
        bw.flush();
    }
}