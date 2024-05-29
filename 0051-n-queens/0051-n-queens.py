class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        visited = [-1] * n
        cnt = 0
        answers = []

        def check(nth_row):
            for row in range(nth_row):
                if visited[nth_row] == visited[row] or nth_row - row == abs(visited[nth_row] - visited[row]):
                    return False
            return True

        def dfs(row):
            if row >= n:
                nonlocal cnt
                cnt += 1
                grid = [['.'] * n for _ in range(n)]
                for idx, value in enumerate(visited):
                    grid[idx][value] = 'Q'

                result = []
                for row in grid:
                    result.append(''.join(row))
                answers.append(result)
                return

            for col in range(n):
                visited[row] = col
                if check(row):
                    dfs(row+1)

        dfs(0)
        return answers