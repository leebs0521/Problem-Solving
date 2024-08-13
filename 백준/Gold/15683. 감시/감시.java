import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] board1, board2;
  static int[] dx = {1, 0, -1, 0}; // 남 동 북 서
  static int[] dy = {0, 1, 0, -1}; // 남 동 북 서


  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int ans = 0;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board1 = new int[N][M];
    board2 = new int[N][M];
    ArrayList<Point> cctv = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board1[i][j] = Integer.parseInt(st.nextToken());
        if (board1[i][j] != 0 && board1[i][j] != 6) {
          cctv.add(new Point(i, j));
        }
        if(board1[i][j] == 0) ans++;
      }
    }

    for (int tmp = 0; tmp < (1 << (2 * cctv.size())); tmp++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          board2[i][j] = board1[i][j];
        }
      }

      int brute = tmp;
      for (int i = 0; i < cctv.size(); i++) {
        int dir = brute % 4;
        brute /= 4;

        int x = cctv.get(i).x;
        int y = cctv.get(i).y;

        if (board1[x][y] == 1) {
          eraseBoard(x, y, dir);
        } else if (board1[x][y] == 2) {
          eraseBoard(x, y, dir);
          eraseBoard(x, y, dir + 2);
        } else if (board1[x][y] == 3) {
          eraseBoard(x, y, dir);
          eraseBoard(x, y, dir + 1);
        } else if (board1[x][y] == 4) {
          eraseBoard(x, y, dir);
          eraseBoard(x, y, dir + 1);
          eraseBoard(x, y, dir + 2);
        } else {
          eraseBoard(x, y, dir);
          eraseBoard(x, y, dir + 1);
          eraseBoard(x, y, dir + 2);
          eraseBoard(x, y, dir + 3);

        }
      }
      int cur = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(board2[i][j] == 0) cur++;
        }
      }
      ans = Math.min(ans, cur);
    }

    bw.write(ans+"");
    bw.flush();
  }

  static boolean check(int x, int y) {
    return x < 0 || x > N - 1 || y < 0 || y > M - 1;
  }

  static void eraseBoard(int x, int y, int direction) {
    direction %= 4;

    while (true) {
      x += dx[direction];
      y += dy[direction];
      if(check(x, y) || board2[x][y] == 6) break;
      if(board2[x][y] != 0) continue;
      board2[x][y] = 7;
    }
  }
}
class Point{
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}