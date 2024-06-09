import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] inputs = br.readLine().split(" ");

            String op = inputs[0];
            if (op.equals("push")) {
                stack.push(Integer.parseInt(inputs[1]));
            } else if (op.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(stack.pop()+"\n");
                }
            } else if (op.equals("size")) {
                bw.write(stack.size()+"\n");
            } else if (op.equals("empty")) {
                int ans = (stack.empty() ? 1 : 0);
                bw.write(ans+"\n");
            } else if (op.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write(-1+"\n");
                } else {
                    bw.write(stack.peek()+"\n");
                }
            } else {
                bw.write(0);
            }
        }
        bw.flush();
    }
}