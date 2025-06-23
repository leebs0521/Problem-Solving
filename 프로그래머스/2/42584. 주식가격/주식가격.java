import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i=1; i<prices.length; i++) {
            
            // 스택이 비어 있거나, 가격이 증가한 경우 push
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        return answer;
    }
}