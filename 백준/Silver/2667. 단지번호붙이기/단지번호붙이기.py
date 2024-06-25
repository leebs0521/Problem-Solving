from collections import deque
import sys

if __name__ == "__main__":
    
    N = int(input())
    graph = []
    visited = [[False] * N for _ in range(N)]
    
    for _ in range(N):
        graph.append(list(map(int, input())))
    
    def DFS(a, b):
        dq = deque()
        dq.append((a,b))
        graph[a][b] = 0
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        cnt = 1
        
        while dq:
            x, y = dq.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if (0 <= nx < N and 0 <= ny < N):
                    if graph[nx][ny] == 1:
                        graph[nx][ny] = 0
                        dq.append((nx, ny))
                        cnt += 1
        return cnt
    
    cnt = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1:
                cnt.append(DFS(i, j))
    
    cnt.sort()
    print(len(cnt))
    print("\n".join(map(str, cnt)))