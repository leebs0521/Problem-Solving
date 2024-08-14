import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K, R, C;
  static int[][] note, paper;

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    note = new int[N][M];

    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      paper = new int[R][C];

      for (int i = 0; i < R; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < C; j++) {
          paper[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int rot = 0; rot < 4; rot++) {
        boolean isPaste = false;
        for (int x = 0; x <= N - R; x++) {
          if(isPaste) break;
          for (int y = 0; y <= M - C; y++) {
            if (pastable(x, y)) {
              isPaste = true;
              break;
            }
          }
        }
        if(isPaste) break;
        rotate();
      }
    }
    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        ans += note[i][j];
      }
    }
    bw.write(ans+"");
    bw.flush();
  }

  static void rotate() {
    int[][] tmp = new int[C][R];

    for (int i = 0; i < C; i++) {
      for (int j = 0; j < R; j++) {
        tmp[i][j] = paper[R - 1 - j][i];
      }
    }

    paper = tmp;
    int temp = R;
    R = C;
    C = temp;
  }

  static boolean pastable(int x, int y) {

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (note[x + i][y + j] == 1 && paper[i][j] == 1) {
          return false;
        }
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (paper[i][j] == 1) {
          note[x + i][y + j] = 1;
        }
      }
    }
    return true;
  }
}