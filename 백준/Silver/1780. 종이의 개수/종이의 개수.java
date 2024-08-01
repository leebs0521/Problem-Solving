import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cnt = new int[3]; // {-1 , 0 , 1} 에 대한 cnt
    static int[][] arr;


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
        func(0, 0, N);
        for (int i = 0; i < 3; i++) {
            bw.write(cnt[i] + "\n");
        }
        bw.flush();
    }

    static void func(int r, int c, int size){
        if(size == 1){
            int val = arr[r][c];
            cnt[val+1]++;
            return;
        }

        int firstVal = arr[r][c];
        boolean isSame = true;
        for(int i=r; i<r+size; i++){
            for (int j = c; j < c+size; j++) {
                if (arr[i][j] != firstVal) {
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame){
            cnt[firstVal+1]++;
            return;
        }
        int reSize = size / 3;
        func(r, c, reSize);
        func(r, c + reSize, reSize);
        func(r, c + 2 * reSize, reSize);
        func(r+reSize, c, reSize);
        func(r+reSize, c+reSize, reSize);
        func(r+reSize, c+ 2*reSize, reSize);
        func(r + 2 * reSize, c, reSize);
        func(r + 2 * reSize, c + reSize, reSize);
        func(r + 2 * reSize, c + 2 * reSize, reSize);
    }
}