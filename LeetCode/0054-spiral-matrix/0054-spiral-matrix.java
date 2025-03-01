class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0, dir = 0;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < rows * cols; i++) {
            ans.add(matrix[y][x]);
            matrix[y][x] = 101;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!(0 <= nx && nx < cols && 0 <= ny && ny < rows && matrix[ny][nx] != 101)) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        return ans;
    }
}