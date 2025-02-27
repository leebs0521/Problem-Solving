class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int price : prices) {
            if (minPrice > price) minPrice = price;
            else ans = Math.max(ans, price - minPrice);
        }
        return ans;
    }
}