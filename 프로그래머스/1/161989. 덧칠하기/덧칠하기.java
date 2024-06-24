import java.util.Arrays;


class Solution {
    public int solution(int n, int m, int[] section) {

        Arrays.sort(section);
        int prev = section[0];
        int answer = 1;
        for (int i=1; i<section.length; i++) {
            int end = prev + m;
            if (end <= section[i]) {
                answer++;
                prev = section[i];
            }
        }
        return answer;
    }
}