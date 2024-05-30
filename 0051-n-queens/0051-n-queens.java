class Solution {

    List<List<String>> answer = new ArrayList<>();
    int[] visited;

    public List<List<String>> solveNQueens(int n) {

        visited = new int[n];
        Arrays.fill(visited, -1);
        dfs(0);

        return answer;
    }

    Boolean is_ok_on(int nth_row, int n){

        for (int row = 0; row < nth_row; row++) {
            if (visited[nth_row] == visited[row] || nth_row - row == Math.abs(visited[nth_row] - visited[row])) {
                return false;
            }
        }

        return true;
    }

    void dfs(int row){

        int n = visited.length;;
        if (row == n) {
            answer.add(constructBoard(visited, n));

            return;
        }

        for (int col = 0; col < n; col++){
            visited[row] = col;
            if (is_ok_on(row, n)) {
                dfs(row+1);
            }
        }
    }

    private List<String> constructBoard(int[] visited, int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++)
            Arrays.fill(board[i], '.');

        for(int i=0; i<n; i++){
            board[i][visited[i]] = 'Q';
        }

        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}