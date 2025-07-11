import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> comboMap = new HashMap<>();

        // 1. 모든 order에 대해 가능한 조합 생성
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for (int len : course) {
                combination(chars, new StringBuilder(), 0, len, comboMap);
            }
        }

        Set<String> ans = new TreeSet<>();

        for (int len : course) {
            int max = 2;
            for (String key : comboMap.keySet()) {
                if (key.length() == len) {
                    max = Math.max(max, comboMap.get(key));
                }
            }
            for (String key : comboMap.keySet()) {
                if(key.length() == len && comboMap.get(key) == max) {
                    ans.add(key);
                }
            }
        }
        
        return ans.toArray(String[]::new);
    }


    // 조합
    private void combination(char[] arr, StringBuilder sb, int idx, int targetLen, Map<String, Integer> comboMap) {
        if (sb.length() == targetLen) {
            String key = sb.toString();
            comboMap.put(key, comboMap.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            combination(arr, sb, i + 1, targetLen, comboMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}