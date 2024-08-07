import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        if(Character.isDigit(s3.charAt(0))){
            int n = Integer.parseInt(s3);
            System.out.println(output(n+1));
            return;
        }

        if(Character.isDigit(s2.charAt(0))){
            int n = Integer.parseInt(s2);
            System.out.println(output(n+2));
            return;
        }

        if(Character.isDigit(s1.charAt(0))){
            int n = Integer.parseInt(s1);
            System.out.println(output(n+3));
            return;
        }

    }

    static String output(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0 && n % 5 != 0) {
            return "Fizz";
        } else if (n % 3 != 0 && n % 5 == 0) {
            return "Buzz";
        } else {
            return n+"";
        }
    }
}