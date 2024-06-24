class Solution {
    public String solution(int n) {
        String answer = "수박";
        
        if(n % 2 == 0) {
            return answer.repeat(n / 2);
        }
        return answer.repeat(n / 2) + "수";
    }
}