class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int cnt = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                nums[k++] = nums[i];
                cnt = 1;
                prev = nums[i];
            } else {
                cnt++;
                if (cnt <= 2) {
                    nums[k++] = nums[i];
                }
            }
        }

        return k;
    }
}