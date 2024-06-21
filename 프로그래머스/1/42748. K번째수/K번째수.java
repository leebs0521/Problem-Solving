import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            ArrayList<Integer> arr = new ArrayList<>();
            for (int x=i-1; x<j; x++){
                arr.add(array[x]);
            }
            Collections.sort(arr);
            answer[idx++] = arr.get(k-1);
        }
        return answer;
    }
}