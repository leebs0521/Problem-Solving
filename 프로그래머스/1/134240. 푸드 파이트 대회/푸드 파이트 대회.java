import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i< food.length; i++) {
            for(int j=0; j<food[i]/2; j++){
                sb.append(i);
            }
        }
        String front = sb.toString() + "0";
        String reverse = sb.reverse().toString();
        return front + reverse;
    }
}