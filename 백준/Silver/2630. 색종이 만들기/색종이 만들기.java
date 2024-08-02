import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] ans = new int[2]; // 흰색 파랑색 종이 개수

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0,0, N);
        bw.write(ans[0] + "\n" + ans[1]);
        bw.flush();

    }

    static void func(int r, int c, int size){
        int prev = arr[r][c];
        boolean possible = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(arr[i][j] != prev){
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            ans[prev]++;
            return;
        }
        int resize = size / 2;
        func(r, c, resize);
        func(r, +c + resize, resize);
        func(r + resize, c, resize);
        func(r + resize, c + resize, resize);
    }
}