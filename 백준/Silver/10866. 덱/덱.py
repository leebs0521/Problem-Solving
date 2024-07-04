from collections import deque
import sys
if __name__ == "__main__":

    N = int(sys.stdin.readline())
    dq = deque()

    for _ in range(N):
        inputs = sys.stdin.readline().split()
        op = inputs[0]
        if op == 'size':
            print(len(dq))

        elif op == 'empty':
            if len(dq) == 0:
                print(1)
            else:
                print(0)

        elif op == 'front':
            if len(dq) == 0:
                print(-1)
            else:
                print(dq[0])

        elif op == 'pop_front':
            if len(dq) == 0:
                print(-1)
            else:
                print(dq.popleft())

        elif op == 'back':
            if len(dq) == 0:
                print(-1)
            else:
                print(dq[-1])
        elif op == 'pop_back':
            if len(dq) == 0:
                print(-1)
            else:
                print(dq.pop())
        elif op == 'push_front':
            dq.appendleft(int(inputs[1]))
        elif op == 'push_back':
            dq.append(int(inputs[1]))
