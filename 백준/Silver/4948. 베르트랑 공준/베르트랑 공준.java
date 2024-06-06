import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MAX =  123456 * 2;
        int[] primeCount = new int[MAX+1];
        Boolean[] isPrime = new Boolean[MAX+1];
        Arrays.fill(isPrime, true);

        for (int i=2; i<(int)Math.sqrt(MAX+1); i++) {

            // i이 현재까지 True 인 경우 확인
            if (isPrime[i]) {
                int j = 2;

                while(i * j <= MAX) {
                    isPrime[i*j] = false;
                    j += 1;
                }
            }
        }

        for (int i=1; i<MAX+1; i++) {
            if (isPrime[i])
                primeCount[i] = primeCount[i-1] + 1;
            else
                primeCount[i] = primeCount[i-1];
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0)
                break;

            bw.write(primeCount[2*n] - primeCount[n]+ "\n");
        }

        bw.flush();

    }
}