import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] chars = new int[26];
        Arrays.fill(chars, -1);

        for (int i=0; i<s.length(); i++) {
            int idx = s.charAt(i)-'a';
            if (chars[idx] == -1){
                answer[i] = -1;
                chars[idx] = i;
            } else {
                answer[i] = i - chars[idx];
                chars[idx] = i;
            }
        }
        return answer;
    }
}