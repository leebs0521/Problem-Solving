from collections import deque
import sys

if __name__ == "__main__":
    
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())
    
    graph = [[] for _ in range((N+1))]
    visited = [False] * (N + 1)
    
    for _ in range(M):
        start, end = map(int, sys.stdin.readline().split())
        graph[start] += [end]
        graph[end] += [start]
        
    visited[1] = True
    q = deque([1])
    
    while q:
        cur = q.popleft()
        for next in graph[cur]:
            if not visited[next]:
                q.append(next)
                visited[next] = True
    
    cnt = 0
    
    for i in range(1, N+1):
        if visited[i]:
            cnt += 1

    print(cnt - 1)