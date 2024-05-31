class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        int[] leftArr = Arrays.copyOfRange(nums, 0, left);
        int[] added = new int[nums.length + leftArr.length];
        System.arraycopy(nums, 0, added, 0, nums.length);
        System.arraycopy(leftArr, 0, added, nums.length, leftArr.length);
        
        int start = left;
        int end = added.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if(added[mid] == target) 
                return mid % nums.length;
            else if (added[mid] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }

        return -1;
    }
}