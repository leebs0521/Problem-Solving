class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int diff = target - (numbers[left] + numbers[right]);
            if (diff == 0)
                return new int[] { left + 1, right + 1 };
            else if (diff > 0)
                left++;
            else
                right--;
        }

        return new int[2];
    }
}