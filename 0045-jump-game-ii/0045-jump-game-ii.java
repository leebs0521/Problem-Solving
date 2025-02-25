class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        if (n <= 1)
            return 0;

        int cnt = 0;
        int possible = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            possible = Math.max(possible, i + nums[i]);

            if (i == cur) {
                cnt++;
                cur = possible;
            }

            if (cur >= n - 1)
                break;
        }

        return cnt;
    }
}