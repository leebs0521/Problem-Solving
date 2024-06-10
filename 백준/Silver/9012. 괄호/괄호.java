import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            Boolean flag = true;

            for (char ch : input.toCharArray()) {
                if (ch == '(') {
                    stack.add(ch);
                } else {
                    if (!stack.isEmpty() && stack.pop() == '(')
                        continue;
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty() || !flag){
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.flush();

    }
}