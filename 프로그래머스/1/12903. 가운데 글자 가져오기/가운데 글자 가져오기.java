class Solution {
    public String solution(String s) {
        // 0 ~ length-1
        int mid = (s.length() - 1) / 2;
        if (s.length() % 2 == 0) {
            return s.charAt(mid) + "" + s.charAt(mid+1);
        }
        return s.charAt(mid)+"";
    }
}