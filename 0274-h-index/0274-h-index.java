class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0, high = citations.length;
        
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            
            if (citations[citations.length - mid] >= mid) {
                low = mid;  // 가능한 h-index가 mid 이상일 경우, 범위를 증가시킴
            } else {
                high = mid - 1;  // 그렇지 않으면 범위를 줄임
            }
        }
        
        return low;
    }
}
