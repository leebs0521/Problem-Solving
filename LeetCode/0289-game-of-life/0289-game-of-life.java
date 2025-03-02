class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] next = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alive = nearBy(board, i, j);
                if (board[i][j] == 1) {
                    if (alive == 2 || alive == 3)
                        next[i][j] = 1;
                } else {
                    if (alive == 3)
                        next[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }

    private int nearBy(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

        int alive = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1) {
                    alive++;
                }
            }
        }

        return alive;
    }
}