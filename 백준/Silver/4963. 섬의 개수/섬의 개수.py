import sys
from collections import deque

if __name__ == "__main__":

    dx = [0, 0, 1, -1, 1, -1, 1, -1]
    dy = [1, -1, 0, 0, 1, 1, -1, -1]

    while True:
        W, H = map(int, sys.stdin.readline().split())
        q = deque()
        cnt = 0
        visited = [[False] * W for _ in range(H)]

        if W == 0 and H == 0:
            break

        def BFS():
            while q:
                x, y = q.popleft()

                for i in range(8):
                    nx, ny = x + dx[i], y + dy[i]

                    if (0 <= nx < H and 0 <= ny < W and graph[nx][ny] == 1 and not visited[nx][ny]):
                        q.append((nx, ny))
                        visited[nx][ny] = True

        graph = []
        for _ in range(H):
            line = list(map(int, sys.stdin.readline().split()))
            graph.append(line)

        for i in range(H):
            for j in range(W):
                if (graph[i][j] == 1 and not visited[i][j]):
                    cnt += 1
                    visited[i][j] = True
                    q.append((i, j))
                    BFS()

        print(cnt)
