import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        Deque<Integer> dq = new LinkedList<>();
        int[] positions = new int[M];
        for (int i=1; i<=N; i++) {
            dq.add(i);
        }

        inputs = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            positions[i] = Integer.parseInt(inputs[i]);
        }

        int cnt = 0;
        for (int position : positions) {
            int idx = 0;
            for(int i : dq) {
                if (position == i) {
                    break;
                }
                idx++;
            }

            if (idx > dq.size() / 2) {
                while (dq.peek() != position) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            } else {
                while (dq.peek() != position) {
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
            }
            dq.poll();
        }

        bw.write(cnt+"\n");
        bw.flush();
    }
}