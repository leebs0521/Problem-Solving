import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
           int n = Integer.parseInt(br.readLine());
           if (n == 0) {
               stack.pop();
           } else {
               stack.push(n);
           }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}