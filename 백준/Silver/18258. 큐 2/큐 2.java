import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] inputs = br.readLine().split(" ");
            String op = inputs[0];

            if (op.equals("push")) {
                q.add(Integer.parseInt(inputs[1]));
            }

            if (op.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(q.pop() + "\n");
                }
            }

            if (op.equals("size")) {
                bw.write(q.size() + "\n");
            }

            if (op.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }

            if (op.equals("front")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(q.peekFirst() + "\n");
                }
            }

            if (op.equals("back")) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(q.peekLast() + "\n");
                }
            }
        }

        bw.flush();
    }
}