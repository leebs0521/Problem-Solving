import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int ans = Integer.MAX_VALUE;
  static int[][] board;

  static ArrayList<Node> house = new ArrayList<>();
  static ArrayList<Node> chicken = new ArrayList<>();
  static boolean[] visited;


  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 1) house.add(new Node(i, j));
        if (board[i][j] == 2) chicken.add(new Node(i, j));
      }
    }

    visited = new boolean[chicken.size()];
    back(0, 0);
    bw.write(ans+"");
    bw.flush();
  }

  private static void back(int depth, int idx) {
    if (depth == M) {
      int total = 0;
      for (int i = 0; i < house.size(); i++) {
        int sum = Integer.MAX_VALUE;
        for (int j = 0; j < chicken.size(); j++) {
          if (visited[j]) {
            int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(
                house.get(i).y - chicken.get(j).y);
            sum = Math.min(sum, dist);
          }
        }
        total += sum;
      }
      ans = Math.min(ans, total);
      return;
    }

    for (int i = idx; i < chicken.size(); i++) {
      if(visited[i]) continue;
      visited[i] = true;
      back(depth + 1, i + 1);
      visited[i] = false;
    }
  }
}
class Node {

  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}