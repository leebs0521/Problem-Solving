import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] videos;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        videos = new int[N][N];
        for (int i = 0; i < N; i++) {
            String inputs[] = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                videos[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        func(0, 0, N);
        bw.flush();

    }

    static void func(int r, int c, int size) throws IOException {
        int prev = videos[r][c];
        boolean possible = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(prev != videos[i][j]){
                    possible = false;
                    break;
                }
            }
        }
        if (possible) {
            bw.write(prev+"");
            return;
        }
        int reSize = size / 2;
        bw.write("(");
        func(r, c, reSize);
        func(r, c + reSize, reSize);
        func(r + reSize, c, reSize);
        func(r + reSize, c + reSize, reSize);
        bw.write(")");
    }
}