import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                func(i, j, N);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void func(int r, int c, int size) throws IOException {
        if ((r / size) % 3 == 1 && (c / size) % 3 == 1)
            bw.write(" ");
        else if (size / 3 == 0)
            bw.write("*");
        else
            func(r, c, size / 3);
    }
}