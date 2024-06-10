import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            Boolean flag = true;
            for (char ch : input.toCharArray()) {

                if (ch == '(' || ch == '[') {
                    stack.add(ch);
                } else if (ch == ')' || ch ==']') {

                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    char c = stack.pop();

                    if ((ch == ']' && c != '[') || (ch == ')' && c != '(')) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (stack.isEmpty() && flag) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}