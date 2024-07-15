import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String ops = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
            Deque<Integer> dq = new LinkedList<>();
            boolean isPossible = true;
            boolean isReversed = false;

            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(arr[i]));
            }

            for (char ch : ops.toCharArray()) {
                if (ch == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        isPossible = false;
                        break;
                    } else {
                        if(isReversed)
                            dq.pollLast();
                        else
                            dq.pollFirst();
                    }
                }
            }
            if (isPossible) {
                bw.write("[");

                while (!dq.isEmpty()) {

                    if(!isReversed)
                        bw.write(dq.pollFirst()+"");
                    else
                        bw.write(dq.pollLast()+"");

                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
    }
}