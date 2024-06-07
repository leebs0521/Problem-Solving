import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            int floor, room;
            room = (N-1) / H + 1;

            if (N % H == 0) {
                floor = H;
            } else {
               floor = N % H;
            }

            bw.write((floor*100+room)+"\n");
        }

        bw.flush();
    }
}