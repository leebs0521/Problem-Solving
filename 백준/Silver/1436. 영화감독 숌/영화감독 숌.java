import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int cur = 665;

        while (n != cnt) {
            cur++;
            if (Integer.toString(cur).contains("666")) {
                cnt++;
            }
        }

        bw.write(cur+"");
        bw.flush();
    }

    private static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

}