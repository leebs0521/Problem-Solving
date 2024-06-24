import java.util.Arrays;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cnt = new int[1001];
        Arrays.fill(cnt, 1);
        for(int i=2; i<1001; i++) {
            for (int j=1; i*j<1001; j++) {
                cnt[i*j]++;
            }
        }
        
        for (int i=left; i<=right; i++) {
            if(cnt[i] % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}