class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.')
                    continue;

                if (rows[i].contains(ch) || cols[j].contains(ch) || boxs[(i / 3) * 3 + (j / 3)].contains(ch)) {
                    return false;
                }
                rows[i].add(ch);
                cols[j].add(ch);
                boxs[(i / 3) * 3 + (j / 3)].add(ch);
            }
        }

        return true;
    }
}