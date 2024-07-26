import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L;
    static int C;
    static String[] str;
    static boolean[] used;
    static String consonant = "aeiou";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        used = new boolean[C];
        str = br.readLine().split(" ");
        Arrays.sort(str);
        comb(0, 0);
        bw.flush();
    }

    static void comb(int depth, int cur) throws IOException {

        if (cur == L) {
            int consCnt = 0;
            int vowCnt = 0;
            boolean possible = true;

            for (int i = 0; i < C; i++) {
                if (used[i]) {
                    if (consonant.contains(str[i]))
                        consCnt++;
                    else
                        vowCnt++;
                }
            }

            if (consCnt >= 1 && vowCnt >= 2) {
                for (int i = 0; i < C; i++) {
                    if (used[i]) bw.write(str[i]);
                }
                bw.newLine();
            }
            return;
        }

        if (depth == C) return;

        used[depth] = true;
        comb(depth + 1, cur + 1);
        used[depth] = false;
        comb(depth + 1, cur);


    }

}