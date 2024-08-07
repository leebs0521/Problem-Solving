import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            bw.write("*".repeat(i));
            bw.write(" ".repeat(2*N-2*i));
            bw.write("*".repeat(i)+"\n");
        }

        for (int i = N-1; i > 0; i--) {
            bw.write("*".repeat(i));
            bw.write(" ".repeat(2*N-2*i));
            bw.write("*".repeat(i)+"\n");
        }

        bw.flush();
    }
}