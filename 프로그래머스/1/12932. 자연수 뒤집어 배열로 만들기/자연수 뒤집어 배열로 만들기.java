class Solution {
    public int[] solution(long n) {
        String nStr = Long.toString(n);
        StringBuilder sb = new StringBuilder(nStr);
        nStr = sb.reverse().toString();
        int[] answer = new int[nStr.length()];
        for (int i=0; i<nStr.length(); i++) {
            answer[i] = Integer.parseInt(nStr.charAt(i) + "");
        }
        return answer;
    }
}