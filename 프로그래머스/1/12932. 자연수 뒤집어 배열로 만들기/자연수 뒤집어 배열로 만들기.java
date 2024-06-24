class Solution {
    public int[] solution(long n) {
        
        String a = n + "";
        String[] arrary = a.split("");
        int[] answer = new int[arrary.length];
        
        for (int i=0; i< arrary.length; i++) {
            answer[i] = Integer.parseInt(arrary[arrary.length - 1 - i]);
        }
        return answer;
    }
}