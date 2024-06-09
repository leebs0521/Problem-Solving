import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int r1 = Integer.parseInt(inputs[2]);
            int x2 = Integer.parseInt(inputs[3]);
            int y2 = Integer.parseInt(inputs[4]);
            int r2 = Integer.parseInt(inputs[5]);

            Double d = getDistance(x1, y1, x2, y2);

            // case 1) 원이 아예 같을 경우
            if (d == 0 && r1 == r2) {
                bw.write(-1+"\n");
            }

            // case 2) 한점에서 만나는 경우
            else if (Math.abs(r1-r2) == d || (r1+r2) == d) {
                bw.write(1+"\n");
            }

            // case 3) 두점에서 만나는 경우
            else if (Math.abs(r1-r2) < d && d < r1+r2) {
                bw.write(2+"\n");
            }

            // case 4) 만나지 않는 경우
            else {
                bw.write(0+"\n");
            }
        }

        bw.flush();
    }

    private static Double getDistance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;

        return Math.sqrt(dx*dx + dy*dy);
    }
}