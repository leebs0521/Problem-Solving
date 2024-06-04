class Solution {
    public int solution(int n) {
        
        String s = n + "";
        int answer = 0;
        
        for (char ch : s.toCharArray()) {
            int num = (int)ch - '0';
            answer += num;
        }
        return answer;
    }
}