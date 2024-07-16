import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else {
                stack.pop();

                if (s.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
    }
}
