class Solution {
    
    public long solution(int price, int money, int count) {
        long answer = count * (count + 1) / 2;
        answer *= price;
        
        return answer > money ? answer - money : 0;
    }
}