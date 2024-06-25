class Solution {
    public int solution(int n) {

        String unsignedString = Integer.toUnsignedString(n, 3);
        StringBuilder sb = new StringBuilder(unsignedString);
        sb.reverse();
        
        return Integer.parseInt(sb.toString(), 3);
    }
}