import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] board1, board2;

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    board1 = new int[N][N];
    board2 = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board1[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;

    for (int tmp = 0; tmp < 1024; tmp++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          board2[i][j] = board1[i][j];
        }
      }

      int brute = tmp;
      for (int i = 0; i < 5; i++) {
        int direction = brute % 4;
        brute /= 4;
        tilt(direction);
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          ans = Math.max(ans, board2[i][j]);
        }
      }
    }

    bw.write(ans+"");
    bw.flush();
  }

  static void rotate(){
    int[][] tmp = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tmp[i][j] = board2[N - 1 - j][i];
      }
    }
    board2 = tmp;
  }

  static void tilt(int direction) {
    while(direction-- > 0) rotate();

    for (int i = 0; i < N; i++) {
      int[] tilted = new int[N];
      int idx = 0;
      for (int j = 0; j < N; j++) {
        if(board2[i][j] == 0) continue;
        if(tilted[idx] == 0)
          tilted[idx] = board2[i][j];
        else if(tilted[idx] == board2[i][j])
          tilted[idx++] *= 2;
        else
          tilted[++idx] = board2[i][j];
      }
      for (int j = 0; j < N; j++) {
        board2[i][j] = tilted[j];
      }
    }
  }
}