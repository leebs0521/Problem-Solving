import sys
from collections import deque

if __name__ == '__main__':
    N = int(sys.stdin.readline())
    stack = deque()

    for _ in range(N):
        inputs = sys.stdin.readline().split()

        if len(inputs) == 2:
            op, x = inputs[0], int(inputs[1])
            if op == "push":
                stack.append(x)
        else:
            op = inputs[0]
            if op == "pop":
                if len(stack) == 0:
                    print(-1)
                else:
                    print(stack.pop())
            elif op == "size":
                print(len(stack))
            elif op == "empty":
                if len(stack) == 0:
                    print(1)
                else:
                    print(0)
            elif op == "top":
                if len(stack) != 0:
                    n = stack.pop()
                    stack.append(n)
                    print(n)
                else:
                    print(-1)
            else:
                print(0)