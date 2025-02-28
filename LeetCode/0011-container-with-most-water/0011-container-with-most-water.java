class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int cur = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, cur);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }
}