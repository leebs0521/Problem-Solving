import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        String ans = "";
        for (int i=sChar.length-1; i>=0; i--) {
            ans += sChar[i];
        }
        
        return ans;
    }
}