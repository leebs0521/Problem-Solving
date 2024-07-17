import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int cur = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                cur *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                cur *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '(') {
                    result += cur;
                }
                stack.pop();
                cur /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (input.charAt(i - 1) == '[') {
                    result += cur;
                }
                stack.pop();
                cur /= 3;
            }
        }

        if(!stack.isEmpty()){
            bw.write("0");
        } else {
            bw.write(result+"");
        }
        bw.flush();
    }
}
