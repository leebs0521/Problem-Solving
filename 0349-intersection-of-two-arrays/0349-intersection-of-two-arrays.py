class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []

        ans = set()

        nums2.sort()


        for n in nums1:
            idx = bisect.bisect_left(nums2, n)
            if idx < len(nums2) and nums2[idx] == n:
                ans.add(n)

        return list(ans)
        