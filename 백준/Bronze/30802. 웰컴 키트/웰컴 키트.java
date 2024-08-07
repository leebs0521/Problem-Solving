import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[inputs.length];
        
        for (int i = 0; i < inputs.length; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int shirt = Integer.parseInt(st.nextToken());
        int pen = Integer.parseInt(st.nextToken());

        int nShirt = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (arr[i] % shirt == 0) {
                nShirt += arr[i] / shirt;
            } else {
                nShirt += arr[i] / shirt + 1;
            }
        }
        System.out.println(nShirt);

        System.out.println(N/pen + " " + N%pen);
    }

}