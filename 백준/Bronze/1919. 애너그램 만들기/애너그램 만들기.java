import java.io.*;

import static java.lang.Math.abs;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char ch : s1.toCharArray()) {
            int idx = (int) (ch - 'a');
            arr1[idx]++;
        }

        for (char ch : s2.toCharArray()) {
            int idx = (int) (ch - 'a');
            arr2[idx]++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                ans += Math.abs(arr1[i] - arr2[i]);
            }
        }

        bw.write(ans+"");
        bw.flush();
    }
}