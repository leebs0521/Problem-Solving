import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> peopleIdx = new HashMap<>();

        int len = id_list.length;
        for (int i = 0; i < id_list.length; i++) {
            peopleIdx.put(id_list[i], i);
        }

        Set[] setList = new Set[len];
        for (int i = 0; i < len; i++) {
            setList[i] = new HashSet<String>();
        }

        for (int i = 0; i < report.length; i++) {
            String id = report[i].split(" ")[0];
            String r = report[i].split(" ")[1];
            int rIdx = peopleIdx.get(r);
            setList[rIdx].add(id);
        }

        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int res = setList[i].size();

            if (res >= k) {
                Iterator<String> it = setList[i].iterator(); // Iterator(반복자) 생성

                while (it.hasNext()) { // hasNext() : 데이터가 있으면 true 없으면 false
                    answer[peopleIdx.get(it.next())]++; // next() : 다음 데이터 리턴
                }
            }
        }
        return answer;
    }
}