class Solution {
    public int solution(String s) {
        int answer = 0;

        while (!s.isEmpty()) {
            int sameCnt = 0;
            int diffCnt = 0;
            char x = s.charAt(0);
            int i;
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == x) {
                    sameCnt++;
                } else {
                    diffCnt++;
                }
                if (sameCnt == diffCnt) {
                    break;
                }
            }
            answer++;
            if (i == s.length()-1 || sameCnt != diffCnt) {
                break;
            }
            if (i+1 == s.length()){
                break;
            }
            s = s.substring(i+1);
        }
        return answer;
    }
}