import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, r, c;

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(zfunc(N, r, c)+ "\n");
        bw.flush();
    }

    static int zfunc(int n, int r, int c) {
        if(n==0) return 0;
        int half = (1 << (n-1));
        if(r < half && c < half) return zfunc(n-1, r, c);
        if(r < half && c >= half) return half*half + zfunc(n-1, r,c-half);
        if(r >= half && c < half) return 2 * half * half + zfunc(n-1, r-half, c);
        return 3 * half * half + zfunc(n-1, r-half, c-half);
    }
}