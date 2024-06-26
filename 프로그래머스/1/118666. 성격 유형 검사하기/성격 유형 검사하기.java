import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] list = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        for (int i = 0; i < 8; i++) {
            map.put(list[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char ch1 = survey[i].charAt(0);
            char ch2 = survey[i].charAt(1);
            int grade = choices[i];

            if(1 <= grade && grade <= 3) {
                map.put(ch1, map.get(ch1) + 4 - grade);

            } else if (5 <= grade && grade <= 7) {
                map.put(ch2, map.get(ch2) + grade - 4);
            }
        }
        String answer = "";
        String[] str = {"RT", "CF", "JM", "AN"};
        for (int i=0; i<4; i++){
            char ch1 = str[i].charAt(0);
            char ch2 = str[i].charAt(1);

            if (map.get(ch1) == map.get(ch2)) {
                answer += (ch1 > ch2) ? ch2 : ch1;
            } else {
                answer += map.get(ch1) > map.get(ch2) ? ch1 : ch2;
            }
        }

        return answer;
    }

}