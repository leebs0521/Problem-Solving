import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (char ch : my_string.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                arr.add((int) ch - '0');
            }
        }

        Collections.sort(arr);
        return arr.stream().mapToInt(i -> i).toArray();
    }
}