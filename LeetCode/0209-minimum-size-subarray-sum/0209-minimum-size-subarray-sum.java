class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = n + 1;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return min == n + 1 ? 0 : min;
    }
}