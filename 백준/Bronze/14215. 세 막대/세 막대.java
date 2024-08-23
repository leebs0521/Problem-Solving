import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int n = 0;
        if(a>b){
            if(b>c) n = a;
            else n = (a>c) ? a : c;
        }
        else n = (b>c) ? b : c;

        if(a+b+c-n > n) System.out.println(a+b+c);
        else System.out.print((a+b+c-n)*2-1);

        br.close();
    }
}