import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            String op = inputs[0];

            if (op.equals("size")) {
                bw.write(dq.size() + "\n");
            } else if (op.equals("empty")) {
                bw.write(dq.isEmpty() ? "1\n" : "0\n");
            } else if (op.equals("front")) {
                bw.write(dq.isEmpty() ? "-1\n" : dq.peekFirst()+"\n");
            } else if (op.equals("back")) {
                bw.write(dq.isEmpty() ? "-1\n" : dq.peekLast()+"\n");
            } else if (op.equals("pop_front")) {
                bw.write(dq.isEmpty() ? "-1\n" : dq.pollFirst()+"\n");
            } else if (op.equals("pop_back")) {
                bw.write(dq.isEmpty() ? "-1\n" : dq.pollLast()+"\n");
            } else if (op.equals("push_back")) {
                dq.add(Integer.parseInt(inputs[1]));
            } else if (op.equals("push_front")) {
                dq.addFirst(Integer.parseInt(inputs[1]));
            }
        }
        bw.flush();
    }
}
