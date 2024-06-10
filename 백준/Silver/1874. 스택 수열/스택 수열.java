import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int element = 1;
        ArrayList<String> answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (element <= num) {
                stack.push(element++);
                answer.add("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                answer.add("-\n");
            }
        }

        if (stack.isEmpty()) {
            for (String word : answer)
                bw.write(word);
        } else {
            bw.write("NO");
        }

        bw.flush();
    }
}