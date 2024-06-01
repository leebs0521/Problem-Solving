class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        for (int[] point: points) {
            heap.offer(point);
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = heap.poll();
        }

        return result;

    }
}