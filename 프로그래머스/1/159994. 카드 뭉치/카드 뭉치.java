class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            int cars1Idx = 0;
            int cars2Idx = 0;
            boolean isPossible = true;

            for (String cur : goal) {
                if (cars1Idx == cards1.length && cars2Idx == cards2.length) {
                    isPossible = false;
                    break;
                }

                if (cars1Idx != cards1.length && cur.equals(cards1[cars1Idx])) {
                    cars1Idx++;
                } else if (cars2Idx != cards2.length && cur.equals(cards2[cars2Idx])) {
                    cars2Idx++;
                } else {
                    isPossible = false;
                    break;
                }

            }

            return isPossible ? "Yes" : "No";
        }
    }