import java.util.ArrayList;

class Solution {
    public int[] solution(String[] strlist) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (String s : strlist) {
            ans.add(s.length());
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}