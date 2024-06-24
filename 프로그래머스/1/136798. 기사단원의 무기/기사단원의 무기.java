import java.util.Arrays;

class Solution {
    
    public int solution(int number, int limit, int power) {
        int[] cnt = new int[number+1];
        int answer = 0;
        Arrays.fill(cnt, 1);
        
        for (int i=2; i<number+1; i++) {
            for (int j=1; i*j<number+1; j++) {
                cnt[i*j] += 1;
            }
        }
        for (int i=1; i<=number; i++) {
            if(cnt[i] > limit) {
                answer += power;
            }
            else {
                answer += cnt[i];
            }
        }
        return answer;
    }
}