import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardOne = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cardTwo = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!goalQueue.isEmpty()) {
            if(!cardOne.isEmpty() && cardOne.peek().equals(goalQueue.peek())) {
                cardOne.poll();
                goalQueue.poll();
            } else if(!cardTwo.isEmpty() && cardTwo.peek().equals(goalQueue.peek())) {
                cardTwo.poll();
                goalQueue.poll();
            } else {
                break;
            }
        }
        
        return goalQueue.isEmpty() ? "Yes" : "No";
    }
}