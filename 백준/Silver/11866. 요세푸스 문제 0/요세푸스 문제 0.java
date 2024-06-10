import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Deque<Integer> deque = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            deque.add(i);
        }

        bw.write("<");
        while (!deque.isEmpty()) {

            for (int i=0; i<M-1; i++) {
                deque.add(deque.pollFirst());
            }
            if (deque.size() == 1)
                bw.write(deque.pop()+"");
            else
                bw.write(deque.pop()+", ");
        }

        bw.write(">");
        bw.flush();


    }
}