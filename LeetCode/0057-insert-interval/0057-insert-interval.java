class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int idx = 0, len = intervals.length;

        while (idx < len && intervals[idx][1] < newInterval[0]) {
            ans.add(intervals[idx++]);
        }

        while (idx < len && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }

        ans.add(newInterval);

        while (idx < len) {
            ans.add(intervals[idx++]);
        }

        return ans.toArray(new int[ans.size()][]);
    }

}