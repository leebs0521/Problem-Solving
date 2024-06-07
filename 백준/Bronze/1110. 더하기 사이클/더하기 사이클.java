import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int initial = Integer.parseInt(br.readLine());
        int n = initial;
        int cnt = 0;

        while (true) {
            n = func(n);
            cnt++;

            if(n == initial)
                break;

        }

        bw.write(cnt+"");
        bw.flush();

    }

    private static int func(int n) {
        if (n < 10) {
            return n * 11;
        } else {
            int sum = n % 10 + n / 10;

            return (n % 10) * 10 + sum % 10;
        }
    }
}