import sys
from collections import deque

if __name__ == '__main__':

    N = int(sys.stdin.readline())
    q = deque()
    for _ in range(N):

        inputs = sys.stdin.readline().split()
        op = inputs[0]

        if op == "push":
            q.append(int(inputs[1]))

        if op == "pop":
            if len(q) == 0:
                print(-1)
            else:
                print(q.popleft())

        if op == "size":
            print(len(q))

        if op == "empty":
            if len(q) == 0:
                print(1)
            else:
                print(0)

        if op == "front":
            if len(q) == 0:
                print(-1)

            else:
                print(q[0])

        if op == "back":
            if len(q) == 0:
                print(-1)

            else:
                print(q[-1])
