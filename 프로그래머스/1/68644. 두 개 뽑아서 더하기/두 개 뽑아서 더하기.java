import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Set<Integer> answer = new HashSet<>();

        for(int i=0; i<len; i++) {
            for (int j = i + 1; j < len; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }


        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}