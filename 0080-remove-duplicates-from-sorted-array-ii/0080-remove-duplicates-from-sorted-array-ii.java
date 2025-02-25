class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int k = 1; // k는 유효한 요소의 인덱스를 추적
        for (int i = 1; i < nums.length; i++) {
            // 현재 숫자가 이전 숫자와 다르면 배열에 새로운 숫자 추가
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            } else if (k > 1 && nums[i] == nums[k - 2]) {
                // 현재 숫자가 이전 두 번째 숫자와 같으면, 이미 두 번 등장한 경우
                continue;
            } else {
                // 두 번째 중복까지만 허용되므로 k 위치에 저장
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
