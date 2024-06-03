import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : array) {
            arr.offer(n);
        }
        arr.offer(height);

        int idx = 0;

        while(!arr.isEmpty()) {
            int temp = arr.poll();
            if(temp == height)
                break;
            idx++;
        }

        return idx;
    }
}