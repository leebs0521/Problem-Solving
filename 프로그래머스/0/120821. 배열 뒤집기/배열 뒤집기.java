class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int len = num_list.length;
        for(int i=0; i<len; i++) {
            answer[i] = num_list[len-1-i];
        }
        return answer;
    }
}