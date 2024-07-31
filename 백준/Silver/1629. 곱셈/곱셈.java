import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A, B, C;

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long ans = multiply(A, B, C);
        bw.write(ans+"");
        bw.flush();
    }

    private static long multiply(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long half = multiply(a, b / 2, c);
        half = (half * half) % c;
        if (b % 2 == 0) {
            return half;
        }
        return a * half % c;
    }
}