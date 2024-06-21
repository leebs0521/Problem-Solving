import sys
from collections import deque

if __name__ == "__main__":
    M, N, H = map(int, sys.stdin.readline().split())
    graph = [[list(map(int, sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]
    
    dx = [0, 0, 1, -1, 0, 0]
    dy = [1, -1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, 1, -1]
    
    q = deque()

    def BFS():
        while q:
            z, x, y = q.popleft()

            for i in range(6):
                nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]

                if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H:
                    if graph[nz][nx][ny] == 0:
                        graph[nz][nx][ny] = graph[z][x][y] + 1
                        q.append((nz, nx, ny))

    for i in range(H):
        for j in range(N):
            for k in range(M):
                if graph[i][j][k] == 1:
                    q.append((i, j, k))

    BFS()

    is_possible = True
    day = 0
    for i in range(H):
        for j in range(N):
            for k in range(M):
                if graph[i][j][k] == 0:
                    is_possible = False
                day = max(day, graph[i][j][k])
    
    if not is_possible:
        print(-1)
    else:
        print(day-1)