import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ans = 0;
        boolean is_minus = false;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if (ch == '-' || ch == '+' || i == chars.length-1) {

                if (i == chars.length-1) {
                    sb.append(ch);
                }
                int n = Integer.parseInt(sb.toString());
                sb = new StringBuilder();

                if(is_minus) {
                    ans -= n;
                } else {
                    ans += n;
                }
            } else {
                sb.append(ch);
            }

            if (ch == '-') {
                is_minus = true;
            }
        }
        bw.write(ans+"");
        bw.flush();
    }

}