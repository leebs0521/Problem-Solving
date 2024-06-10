import sys
from collections import deque

if __name__ == '__main__':

    N, K = map(int, sys.stdin.readline().split())

    q = deque([i for i in range(1, N+1)])
    ans = []
    while q:
        for _ in range(K):
            q.append(q.popleft())

        ans.append(str(q.pop()))

    print("<" + ", ".join(ans) + ">")