import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        Stack<Point> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for (int i = 1; i <= N; i++) {
            int curValue = Integer.parseInt(st.nextToken());
            Point cur = new Point(i, curValue);

            while (!s.isEmpty()) {
                if (cur.value > s.peek().value) {
                    s.pop();
                } else {
                    ans[i-1] = s.peek().idx;
                    break;
                }
            }
            s.push(cur);
        }

        for (int i = 0; i < N; i++) {
            bw.write(ans[i]+ " ");
        }
        bw.flush();
    }
}

class Point{
    int idx;
    int value;

    public Point(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}