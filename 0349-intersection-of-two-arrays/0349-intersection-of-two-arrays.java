class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums2);

        for (int n : nums1) {
            int idx = Arrays.binarySearch(nums2, n);
            if(idx >= 0) {
                set.add(n);
            }
        }

        return set.stream().mapToInt(i->i).toArray();
    }
}