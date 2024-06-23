import java.util.Arrays;

class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;
            Arrays.sort(score);
            int len = score.length;
            for (int i=len-m; i>=0; i-=m) {
                answer += m * score[i];
            }
            
            return answer;
        }
    }