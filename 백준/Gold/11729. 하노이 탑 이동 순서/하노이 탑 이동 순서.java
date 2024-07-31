import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        bw.write(((1 << N) - 1 ) + "\n");
        hanoi(1, 3, N);
        bw.flush();
   }

   static void hanoi(int a, int b, int n) throws IOException {
        if (n == 1){
            bw.write(a + " " + b + "\n");
            return;
        }
        hanoi(a, 6-a-b, n-1);
        bw.write(a + " " + b + "\n");
        hanoi(6-a-b, b, n-1);
   }
}