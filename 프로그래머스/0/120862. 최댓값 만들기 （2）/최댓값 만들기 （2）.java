import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int ans1 = numbers[0] * numbers[1];
        int ans2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return Math.max(ans1, ans2);
    }
}