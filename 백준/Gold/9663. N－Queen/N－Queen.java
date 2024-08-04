import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int cnt;
    static boolean[] used;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        used = new boolean[N];
        board = new int[N];
        queen(0);
        bw.write(cnt + " ");
        bw.flush();
    }

    static void queen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for(int i=0; i<N;i++){
            if(used[i]) continue;
            used[i] = true;
            board[depth] = i;

            if(possible(depth)){
                queen(depth+1);
            }

            used[i] = false;
        }
    }

    private static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if(Math.abs(depth - i) == Math.abs(board[depth] - board[i]))
                return false;
        }
        return true;
    }
}
