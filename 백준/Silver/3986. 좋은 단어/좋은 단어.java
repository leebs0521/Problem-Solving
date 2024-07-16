import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int ans = 0;
        while(T-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    if (stack.peek() == ch) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }

            if (stack.isEmpty()) {
                ans++;
            }
        }
        bw.write(ans + "");
        bw.flush();
    }
}
