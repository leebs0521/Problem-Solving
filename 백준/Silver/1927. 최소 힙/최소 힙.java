import java.io.*;
import java.util.PriorityQueue;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (heap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(heap.poll()+"\n");
                }
            } else {
                heap.add(n);
            }
        }

        bw.flush();
    }
}