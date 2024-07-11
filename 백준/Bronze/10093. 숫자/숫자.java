import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);

        if (a == b) {
            bw.write("0");
            bw.flush();
            return;
        }
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        bw.write(b - a - 1 + "\n");
        for (long i = a + 1; i < b; i++) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}
