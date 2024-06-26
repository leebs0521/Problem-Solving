import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int cnt = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            if (ingredient[i] == 1 && s.size() >= 3) {
                int iMinus1 = s.pop();
                int iMinus2 = s.pop();
                int iMinus3 = s.pop();
                
                if(iMinus3 == 1 && iMinus2 == 2 && iMinus1 == 3){
                    cnt++;
                } else {
                    s.push(iMinus3);
                    s.push(iMinus2);
                    s.push(iMinus1);
                    s.push(ingredient[i]);
                }
            } else {
                s.push(ingredient[i]);
            }
        }
        return cnt;
    }
}