import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty() || (stack.pop() != '(')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}