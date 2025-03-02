class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<Point> q = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < m; i++) {
                matrix[cur.x][i] = 0;
            }

            for (int i = 0; i < n; i++) {
                matrix[i][cur.y] = 0;
            }
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}