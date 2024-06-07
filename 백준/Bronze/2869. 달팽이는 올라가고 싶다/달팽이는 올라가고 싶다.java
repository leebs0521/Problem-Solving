import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int A = Integer.parseInt(s.split(" ")[0]);
        int B = Integer.parseInt(s.split(" ")[1]);
        int V = Integer.parseInt(s.split(" ")[2]);
        int res;
        if(V == A) {
            bw.write(1 + "");
        } else {
            int minus = V - A;
            if (minus % (A - B) == 0)
                res = minus / (A - B) + 1;
            else
                res = minus / (A - B) + 2;
            bw.write(res + "");
        }
        bw.flush();
    }
}