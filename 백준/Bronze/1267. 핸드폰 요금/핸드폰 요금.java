import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int yPrice = 0;
        int mPrice = 0;

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(inputs[i]);

            yPrice += (10 + 10 * (time/30));
            mPrice += (15 + 15 * (time/60));

        }

        if (mPrice > yPrice) {
            bw.write("Y " + yPrice);
        } else if (yPrice > mPrice){
            bw.write("M " + mPrice);
        } else {
            bw.write("Y M " + mPrice);
        }

        bw.flush();
    }
}