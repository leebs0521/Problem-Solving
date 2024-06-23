import java.util.ArrayList;

class Solution {
        public int[] solution(int[] answers) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
            int[] cnts = new int[3];
            ArrayList <Integer> ans = new ArrayList<>();
            for (int i=0; i<answers.length; i++) {
                if (arr1[i%arr1.length] == answers[i]) {
                    cnts[0]++;
                }
                if (arr2[i%arr2.length] == answers[i]) {
                    cnts[1]++;
                }
                if (arr3[i%arr3.length] == answers[i]) {
                    cnts[2]++;
                }
            }
            int max = Math.max(Math.max(cnts[0], cnts[1]), cnts[2]);
            for (int i=0; i<3; i++) {
                if (max == cnts[i]) {
                    ans.add(i+1);
                }
                    
            }
            
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }