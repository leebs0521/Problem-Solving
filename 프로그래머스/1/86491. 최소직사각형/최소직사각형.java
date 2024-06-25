class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxCol = 0;
        
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            maxRow = Math.max(maxRow, size[0]);
            maxCol = Math.max(maxCol, size[1]);
        }
        
       return maxCol * maxRow;
    }
}