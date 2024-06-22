import java.util.*;

class Solution {
    public long solution(long n) {
        String nStr = Long.toString(n);
        char[] nArr = nStr.toCharArray();
        Arrays.sort(nArr);
        StringBuilder sb = new StringBuilder(new String(nArr));
        sb.reverse();

        return Long.parseLong(sb.toString());
    }
}