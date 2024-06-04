import java.io.*;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Main{
    public static int install_router(int[] lst, int C) {

        // 배열 정렬
        Arrays.sort(lst);

        int low = 1;
        int high = lst[lst.length-1] - lst[0];
        int minGap = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            int cur = lst[0];
            int cnt = 1;

            for(int i=1; i<lst.length; i++) {

                if(lst[i] >= cur + mid) {
                    cur = lst[i];
                    cnt++;
                }
            }

            if (cnt >= C) {
                minGap = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return minGap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = parseInt(str.split(" ")[0]);
        int C = parseInt(str.split(" ")[1]);

        int[] lst = new int[N];

        for (int i = 0; i < N; i++) {
            lst[i] = parseInt(br.readLine());
        }

        bw.write(install_router(lst, C)+"");
        bw.flush();
    }
}