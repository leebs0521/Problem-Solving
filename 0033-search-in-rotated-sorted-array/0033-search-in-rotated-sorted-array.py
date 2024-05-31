class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1

        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
                
        
        added = nums + nums[:left]
        
        start = left
        end = len(added) - 1
        answer = -1
        
        while start <= end:
            mid = (start + end) // 2
            
            if added[mid] == target:
                answer = mid % len(nums)
                break
            elif added[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
                
        return answer