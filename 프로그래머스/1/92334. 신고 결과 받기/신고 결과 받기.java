import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고한 유저 저장한 집합
        // 신고된 유저 집합
        int n = id_list.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(id_list[i], i);
        }

        HashSet<String>[] set1 = new HashSet[n];
        HashSet<String>[] set2 = new HashSet[n];
        for (int i = 0; i < n; i++) {
            set1[i] = new HashSet<>();
            set2[i] = new HashSet<>();
        }

        for (int i = 0; i < report.length; i++) {
            String[] token = report[i].split(" ");
            String source = token[0];
            String target = token[1];
            set1[map.get(source)].add(target);
            set2[map.get(target)].add(source);
        }

        List<String> banList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (set2[i].size() >= k) {
                banList.add(id_list[i]);
            }
        }

        int[] answer = new int[n];
        int cnt;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (String banUser : banList) {
                if (set1[i].contains(banUser)) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}