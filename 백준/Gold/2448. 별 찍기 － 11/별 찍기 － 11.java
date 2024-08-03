import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][2 * N-1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
        star(N, 0, N-1);
        for (int i = 0; i < N; i++) {
            bw.write(new String(arr[i]) +"\n");
        }
        bw.flush();

    }

    static void star(int size, int r, int c) {
        if (size == 3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = '*';
            arr[r + 1][c + 1] = '*';
            arr[r+2][c-2] = '*';
            arr[r+2][c-1] = '*';
            arr[r+2][c] = '*';
            arr[r+2][c+1] = '*';
            arr[r+2][c+2] = '*';
            return;
        }
        int reSize = size / 2;
        star(reSize, r, c);
        star(reSize, r + reSize, c - reSize);
        star(reSize, r + reSize, c + reSize);

    }
}