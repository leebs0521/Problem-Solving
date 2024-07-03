from collections import deque
import sys

if __name__ == "__main__":

    H, W = map(int, sys.stdin.readline().split())

    board = []
    cnt = 0
    for _ in range(H):
        board.append(list(map(int, sys.stdin.readline().split())))

    def BFS(a, b):
        dq = deque()
        dq.append((a, b))
        dx = [0, 0, 1, -1, 1, -1, -1, 1]
        dy = [1, -1, 0, 0, -1, 1, -1, 1]

        while dq:
            x, y = dq.popleft()

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if (0 <= nx < H and 0 <= ny < W):
                    if (board[nx][ny] == 1):
                        board[nx][ny] = 0
                        dq.append((nx, ny))

    for x in range(H):
        for y in range(W):
            if board[x][y] == 1:
                cnt += 1
                board[x][y] = 0
                BFS(x, y)

    print(cnt)