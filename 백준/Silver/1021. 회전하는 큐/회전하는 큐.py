import sys
from collections import deque

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())

    dq = deque([i for i in range(1, N+1)])
    lst = list(map(int, sys.stdin.readline().split()))
    cnt = 0
    for n in lst:
        idx = 0
        for i in range(len(dq)):
            if dq[i] == n:
                idx = i
                break
        # idx  0 보다는 같거나 크고  len(dq)-1 보다 같거나 작다.

        ## 중간 위치 보다 크다면
        if idx > len(dq) // 2:
            # 우측 로테이션
            while dq[0] != n:
                element = dq.pop()
                dq.appendleft(element)
                cnt += 1
        else:
            # 왼쪽 로테이션
            while dq[0] != n:
                element = dq.popleft()
                dq.append(element)
                cnt += 1

        dq.popleft()

    print(cnt)