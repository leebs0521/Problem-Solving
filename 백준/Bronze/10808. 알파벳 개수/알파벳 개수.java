import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            int idx = (int)(ch - 'a');
            cnt[idx]++;
        }

        for (int c : cnt) {
            bw.write(c + " ");
        }

        bw.flush();
    }
}