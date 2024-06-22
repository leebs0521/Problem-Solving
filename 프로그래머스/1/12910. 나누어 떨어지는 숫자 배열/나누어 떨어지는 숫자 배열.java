import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        for (int n : arr) {
            if (n % divisor == 0) {
                list.add((n));
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}