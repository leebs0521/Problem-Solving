import sys
from collections import deque
input = sys.stdin.readline

short = lambda x:(x[0],x[1])

def bfs(p1,p2):
    cnt = 0
    queue = deque([[p1,cnt]])
    while queue:
        v1,cnt = short(queue.popleft())
        if v1 == p2:
            return cnt
        if not visited[v1]:
            cnt += 1
            visited[v1] = True
            for i in parent[v1]:
                if not visited[i]:
                    queue.append([i, cnt])
    return -1

n = int(input())
p1, p2 = map(int, input().split())
m = int(input())
parent = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    x,y = map(int, input().split())
    parent[x].append(y)
    parent[y].append(x)

print(bfs(p1, p2))