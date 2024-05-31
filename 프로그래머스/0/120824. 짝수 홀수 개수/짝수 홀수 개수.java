class Solution {
    public int[] solution(int[] num_list) {
        int odd_cnt = 0;
        int even_cnt = 0;
        
        for (int i : num_list) {
            if (i % 2 == 0)
                even_cnt++;
            else 
                odd_cnt++;
        }
        return new int[]{even_cnt, odd_cnt};
    }
}